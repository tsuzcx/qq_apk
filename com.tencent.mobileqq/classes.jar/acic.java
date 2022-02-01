import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.1;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.2;
import org.json.JSONObject;

public final class acic
{
  public static void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)) || (paramJSONObject.length() <= 0)) {
      return;
    }
    try
    {
      paramJSONObject.put("ct", System.currentTimeMillis());
      b(paramJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        acho.d("GdtReportForAntiSpam", "reportAntiSpamForClick", localThrowable);
      }
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)) || (paramJSONObject.length() <= 0)) {
      return;
    }
    try
    {
      paramJSONObject.put("cn_t", AdNet.getType(BaseApplicationImpl.getApplication()));
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.1(arrayOfByte, paramJSONObject), 4);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        acho.d("GdtReportForAntiSpam", "receiveReportForAntiSpamOnReportServer", localThrowable);
      }
    }
  }
  
  public static void c(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)) || (paramJSONObject.length() <= 0)) {
      return;
    }
    byte[] arrayOfByte = paramJSONObject.toString().getBytes();
    AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.2(arrayOfByte, paramJSONObject), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acic
 * JD-Core Version:    0.7.0.1
 */