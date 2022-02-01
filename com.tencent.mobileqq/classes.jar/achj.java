import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class achj
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacfw != null) {}
    for (paramVarArgs = paramacfw.a(); (paramacfw == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      acho.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("netType", achq.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramacfw.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramacfw != null) {
            paramString = paramacfw.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getNetType", paramString);
          return true;
          localJSONException = localJSONException;
          acho.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          acho.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achj
 * JD-Core Version:    0.7.0.1
 */