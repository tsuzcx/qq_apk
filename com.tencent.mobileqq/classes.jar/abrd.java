import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abrd
  extends abre
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    if (paramabqc != null) {}
    for (localActivity = paramabqc.a(); (paramabqc == null) || (localActivity == null); localActivity = null)
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
        paramabqc.callJs(paramString, new String[] { localObject });
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "getAdInfo", paramabqc.a());
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
 * Qualified Name:     abrd
 * JD-Core Version:    0.7.0.1
 */