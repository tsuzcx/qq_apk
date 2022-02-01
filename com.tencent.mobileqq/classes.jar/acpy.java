import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class acpy
  implements acqj
{
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacpp != null) {}
    for (paramVarArgs = paramacpp.a(); (paramacpp == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      acqy.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", acsa.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramacpp.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramacpp != null) {
            paramString = paramacpp.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          acqy.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          acqy.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpy
 * JD-Core Version:    0.7.0.1
 */