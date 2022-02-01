import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class acub
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacts != null) {}
    for (paramVarArgs = paramacts.a(); (paramacts == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      acvc.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", acwe.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramacts.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramacts != null) {
            paramString = paramacts.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          acvc.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          acvc.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acub
 * JD-Core Version:    0.7.0.1
 */