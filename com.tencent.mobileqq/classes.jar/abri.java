import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.JsonUploadRunnable;
import com.tencent.mfsdk.reporter.QCloudFileUploadRunnable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class abri
  implements abrg
{
  private static final String jdField_a_of_type_JavaLangString = String.format(Locale.US, "https://sngapm.qq.com/entrance/%d/uploadFile/", new Object[] { Integer.valueOf(MagnifierSDK.jdField_a_of_type_Int) });
  private static final String b = String.format(Locale.US, "https://sngapm.qq.com/entrance/%d/uploadJson/", new Object[] { Integer.valueOf(MagnifierSDK.jdField_a_of_type_Int) });
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public abri(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(paramHandlerThread.getLooper());
    }
  }
  
  public boolean a(ResultObject paramResultObject, abrh paramabrh)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      return false;
    }
    JSONObject localJSONObject = paramResultObject.params;
    Object localObject3 = localJSONObject.optJSONObject("fileObj");
    Object localObject1 = localJSONObject.optJSONObject("clientinfo");
    int i;
    String str1;
    for (;;)
    {
      try
      {
        if (localJSONObject.has("newplugin"))
        {
          i = localJSONObject.getInt("newplugin");
          localObject2 = ((JSONObject)localObject1).keys();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str1 = (String)((Iterator)localObject2).next();
          localJSONObject.put(str1, ((JSONObject)localObject1).getString(str1));
          continue;
        }
        i = ((JSONObject)localObject1).getInt("plugin");
      }
      catch (Throwable paramResultObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Magnifier_QCloudReporter", 2, "[qcloud_report] exception: ", paramResultObject);
        }
        return false;
      }
    }
    localJSONObject.put("version", MagnifierSDK.jdField_a_of_type_JavaLangString);
    localJSONObject.put("manu", Build.BRAND);
    localJSONObject.put("device", Build.MODEL);
    Object localObject2 = ((JSONObject)localObject1).getString("rdmuuid");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "0";
    }
    localJSONObject.put("rdmuuid", localObject1);
    localJSONObject.put("api_ver", 1);
    localJSONObject.put("plugin_ver", 1);
    localJSONObject.put("client_identify", UUID.randomUUID());
    localJSONObject.put("platform", "android");
    localJSONObject.put("plugin", i);
    localJSONObject.remove("clientinfo");
    localObject1 = new StringBuffer(1024);
    if ((localObject3 != null) && (i != 102))
    {
      localObject2 = ((JSONObject)localObject3).getString("fileObj1");
      localJSONObject.put("fileObj", localObject2);
      localObject3 = localJSONObject.keys();
      str1 = (String)((Iterator)localObject3).next();
      String str2 = localJSONObject.getString(str1);
      ((StringBuffer)localObject1).append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      while (((Iterator)localObject3).hasNext())
      {
        str1 = (String)((Iterator)localObject3).next();
        str2 = localJSONObject.getString(str1);
        ((StringBuffer)localObject1).append("&").append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      }
      ((StringBuffer)localObject1).append("&a=1");
      localObject1 = jdField_a_of_type_JavaLangString + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] file url: " + (String)localObject1);
      }
      paramResultObject = new QCloudFileUploadRunnable(new URL((String)localObject1), (String)localObject2, localJSONObject, paramabrh, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
    }
    else
    {
      ((StringBuffer)localObject1).append("p_id=").append(localJSONObject.getString("p_id")).append("&plugin=").append(i);
      ((StringBuffer)localObject1).append("&version=").append(URLEncoder.encode(MagnifierSDK.jdField_a_of_type_JavaLangString, "UTF-8")).append("&a=1");
      localObject1 = b + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] json url: " + (String)localObject1 + " jsonObj: " + localJSONObject.toString());
      }
      paramResultObject = new JsonUploadRunnable(new URL((String)localObject1), localJSONObject, paramabrh, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abri
 * JD-Core Version:    0.7.0.1
 */