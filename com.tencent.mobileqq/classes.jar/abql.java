import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class abql
  implements abqx
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramabqc != null) {}
    for (paramVarArgs = paramabqc.a(); (paramabqc == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      abrl.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", absm.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramabqc.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramabqc != null) {
            paramString = paramabqc.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          abrl.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          abrl.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abql
 * JD-Core Version:    0.7.0.1
 */