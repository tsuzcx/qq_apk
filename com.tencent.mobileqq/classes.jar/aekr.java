import android.text.TextUtils;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class aekr
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("WebCoreDump", 1, "-->start load config at " + l);
    Object localObject1;
    if (VipWebViewReportLog.a() == null)
    {
      localObject1 = "";
      localObject1 = new File(VipWebViewReportLog.jdField_b_of_type_JavaLangString + (String)localObject1 + "config.json");
      if (!((File)localObject1).exists()) {
        break label391;
      }
      QLog.d("WebCoreDump", 1, "-->config file exist");
      VipWebViewReportLog.jdField_a_of_type_Int = 0;
      VipWebViewReportLog.a(VipWebViewReportLog.a());
    }
    for (;;)
    {
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONObject((String)localObject1);
          VipWebViewReportLog.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("js_report", true);
          VipWebViewReportLog.jdField_b_of_type_Boolean = ((JSONObject)localObject1).optBoolean("url_check", true);
          if (!((JSONObject)localObject1).has("url_list")) {
            continue;
          }
          JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("url_list");
          int j = localJSONArray.length();
          int i = 0;
          if (i < j)
          {
            VipWebViewReportLog.jdField_a_of_type_JavaUtilSet.add(localJSONArray.getString(i));
            i += 1;
            continue;
            localObject1 = VipWebViewReportLog.a().getAccount();
            break;
          }
          QLog.d("WebCoreDump", 1, "-->url white list:" + VipWebViewReportLog.jdField_a_of_type_JavaUtilSet);
          if ((VipWebViewReportLog.jdField_b_of_type_Boolean) && (!((JSONObject)localObject1).has("url_list"))) {
            continue;
          }
          VipWebViewReportLog.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        }
      }
      catch (Exception localException)
      {
        VipWebViewReportLog.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        QLog.d("WebCoreDump", 1, "-->read config file err:" + localException.toString());
        VipWebViewReportLog.b();
        continue;
        VipWebViewReportLog.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        continue;
      }
      finally
      {
        VipWebViewReportLog.b();
      }
      QLog.d("WebCoreDump", 1, "parse config cost=" + (System.currentTimeMillis() - l));
      return;
      QLog.d("WebCoreDump", 1, "-->No url white list in config!" + ((JSONObject)localObject1).toString());
      continue;
      label391:
      VipWebViewReportLog.a(VipWebViewReportLog.a());
      VipWebViewReportLog.b();
      QLog.d("WebCoreDump", 1, "-->config file not exist: " + localObject2.getPath());
      VipWebViewReportLog.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekr
 * JD-Core Version:    0.7.0.1
 */