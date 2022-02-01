import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class acut
  extends acuv
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    if (paramacts != null) {}
    for (Activity localActivity = paramacts.a(); (paramacts == null) || (localActivity == null); localActivity = null)
    {
      QLog.i("EndCardWebGdtMvWebEndcardClickHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    String str = "";
    try
    {
      QLog.i("EndCardWebGdtMvWebEndcardClickHandler", 1, "args = " + paramVarArgs[0]);
      paramVarArgs = new JSONObject(paramVarArgs[0]).optString("antiSpam");
      a(paramVarArgs);
    }
    catch (Throwable paramVarArgs)
    {
      try
      {
        paramacts.callJs(paramString, new String[] { "" });
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleRewardVideoClick", paramacts.a());
        return true;
        paramVarArgs = paramVarArgs;
        QLog.i("EndCardWebGdtMvWebEndcardClickHandler", 1, "json", paramVarArgs);
        paramVarArgs = str;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.i("EndCardWebGdtMvWebEndcardClickHandler", 1, "callJs", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acut
 * JD-Core Version:    0.7.0.1
 */