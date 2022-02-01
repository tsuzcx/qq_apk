import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.1;
import org.json.JSONObject;

public final class acvo
{
  public static void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject;
      if (!JSONObject.NULL.equals(paramJSONObject)) {}
    }
    else
    {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("ct", System.currentTimeMillis());
      b(localJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        acvc.d("GdtReportForAntiSpam", "reportAntiSpamForClick", paramJSONObject);
      }
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.toString().getBytes();
    AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.1(paramJSONObject), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvo
 * JD-Core Version:    0.7.0.1
 */