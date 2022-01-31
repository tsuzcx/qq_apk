import android.os.HandlerThread;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.JsonUploadRunnable;
import com.tencent.mfsdk.reporter.YunYingFileUploadRunnable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aaaq
  implements aaaj
{
  private MqqHandler a;
  
  public aaaq(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.a = new MqqHandler(paramHandlerThread.getLooper());
    }
  }
  
  public boolean a(ResultObject paramResultObject, aaak paramaaak)
  {
    if (this.a == null) {
      return false;
    }
    JSONObject localJSONObject = paramResultObject.params.optJSONObject("fileObj");
    if (localJSONObject != null)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = new StringBuffer(1024);
        localObject2 = paramResultObject.params.getJSONObject("clientinfo");
        localIterator = ((JSONObject)localObject2).keys();
        localObject3 = (String)localIterator.next();
        String str = ((JSONObject)localObject2).getString((String)localObject3);
        ((StringBuffer)localObject1).append((String)localObject3).append("=").append(URLEncoder.encode(str, "UTF-8"));
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          str = ((JSONObject)localObject2).getString((String)localObject3);
          ((StringBuffer)localObject1).append("&").append((String)localObject3).append("=").append(URLEncoder.encode(str, "UTF-8"));
        }
        localObject1 = "http://zhizi.qq.com/chunkupload.php?" + ((StringBuffer)localObject1).toString();
      }
      catch (Exception paramResultObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Magnifier_YunYingReporter", 2, paramResultObject, new Object[0]);
        }
        return false;
      }
      Object localObject2 = new URL((String)localObject1);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        localObject3 = localJSONObject.getString((String)localIterator.next());
        if (QLog.isColorLevel()) {
          QLog.i("Magnifier_YunYingReporter", 2, "[yun_ying_report]:" + (String)localObject1 + " " + (String)localObject3);
        }
        localObject3 = new YunYingFileUploadRunnable((URL)localObject2, (String)localObject3, paramaaak, paramResultObject.dbId, this.a);
        this.a.post((Runnable)localObject3);
      }
    }
    localJSONObject = paramResultObject.params;
    if (QLog.isColorLevel()) {
      QLog.i("Magnifier_YunYingReporter", 2, "[yun_ying_report]:" + localJSONObject.toString());
    }
    paramResultObject = new JsonUploadRunnable(new URL("http://zhizi.qq.com/json.php"), localJSONObject, paramaaak, paramResultObject.dbId, this.a);
    this.a.post(paramResultObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaq
 * JD-Core Version:    0.7.0.1
 */