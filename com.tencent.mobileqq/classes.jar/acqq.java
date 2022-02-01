import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class acqq
  extends acqr
{
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    if (paramacpp != null) {}
    for (localActivity = paramacpp.a(); (paramacpp == null) || (localActivity == null); localActivity = null)
    {
      QLog.i("EndCardWebGdtMvWebGetAdInfoHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    localObject = "";
    try
    {
      String str = new JSONObject(paramVarArgs[0]).optString("traceId");
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramacpp.callJs(paramString, new String[] { localObject });
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "getAdInfo", paramacpp.a());
        return true;
        localThrowable = localThrowable;
        QLog.i("EndCardWebGdtMvWebGetAdInfoHandler", 1, "json", localThrowable);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.i("EndCardWebGdtMvWebGetAdInfoHandler", 1, "callJs", paramString);
        }
      }
    }
    localObject = String.format("{\"adInfo\":%s}", new Object[] { a((String)localObject) });
    QLog.i("EndCardWebGdtMvWebGetAdInfoHandler", 1, "args=" + paramVarArgs[0] + ",result=" + (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqq
 * JD-Core Version:    0.7.0.1
 */