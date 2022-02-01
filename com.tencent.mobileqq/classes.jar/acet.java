import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class acet
{
  private String a;
  private String b;
  
  public acet(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  protected long a(long paramLong)
  {
    return NetConnInfoCenter.servetTimeSecondInterv * 1000L + paramLong;
  }
  
  protected JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      localJSONObject.put("app", String.valueOf(this.b));
      localJSONObject.put("pkg", localBaseApplicationImpl.getPackageName());
      localJSONObject.put("sv", "8.4.10");
      localJSONObject.put("sdk_st", 2);
      localJSONObject.put("ov", String.valueOf(Build.VERSION.RELEASE));
      localJSONObject.put("os", 2);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtMvEndCardWebReportHelper", 1, "buildParams", localThrowable);
    }
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, null);
  }
  
  public void a(long paramLong, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.a))
    {
      QLog.i("GdtMvEndCardWebReportHelper", 1, "reportWebEndCardLoading traceId is empty");
      return;
    }
    JSONObject localJSONObject1 = a();
    if (localJSONObject1 == null)
    {
      QLog.i("GdtMvEndCardWebReportHelper", 1, "reportWebEndCardLoading local param is null");
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONObject1.put("events", localJSONArray);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("seq", 1);
      localJSONObject2.put("ts", a(System.currentTimeMillis()));
      localJSONObject2.put("ei", paramLong);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject2.put("biz", localJSONObject3);
      localJSONObject3.put("traceid", this.a);
      if (paramJSONObject != null) {
        localJSONObject2.put("ext", paramJSONObject);
      }
      localJSONArray.put(localJSONObject2);
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        QLog.e("GdtMvEndCardWebReportHelper", 1, "reportWebEndCardLoading buildParams", paramJSONObject);
      }
    }
    QLog.i("GdtMvEndCardWebReportHelper", 1, "reportWebEndCardLoading " + localJSONObject1.toString());
    acic.c(localJSONObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acet
 * JD-Core Version:    0.7.0.1
 */