import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abrc
  extends abre
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    if (paramabqc != null) {}
    for (Activity localActivity = paramabqc.a(); (paramabqc == null) || (localActivity == null); localActivity = null)
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
        paramabqc.callJs(paramString, new String[] { "" });
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleRewardVideoClick", paramabqc.a());
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
 * Qualified Name:     abrc
 * JD-Core Version:    0.7.0.1
 */