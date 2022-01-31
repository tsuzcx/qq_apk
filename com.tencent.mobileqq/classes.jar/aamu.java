import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aamu
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    for (paramVarArgs = paramaamm.a(); (paramaamm == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aanp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", aaor.a(paramVarArgs));
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          aanp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          aanp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamu
 * JD-Core Version:    0.7.0.1
 */