import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aanj
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    for (paramVarArgs = paramaamm.a(); (paramaamm == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aanp.d("GdtMacJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("macAddress", aaor.b(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramaamm.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramaamm != null) {
            paramString = paramaamm.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getMacAddress", paramString);
          return true;
          localJSONException = localJSONException;
          aanp.d("GdtMacJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          aanp.d("GdtMacJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanj
 * JD-Core Version:    0.7.0.1
 */