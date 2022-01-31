import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aarj
  implements aaru
{
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaarb != null) {}
    for (paramVarArgs = paramaarb.a(); (paramaarb == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aase.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", aatg.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramaarb.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramaarb != null) {
            paramString = paramaarb.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          aase.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          aase.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarj
 * JD-Core Version:    0.7.0.1
 */