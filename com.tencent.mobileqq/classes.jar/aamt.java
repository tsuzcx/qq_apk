import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aamt
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    for (paramVarArgs = paramaamm.a(); (paramaamm == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aanp.d("GdtCarrierJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("carrier", aaor.a(paramVarArgs));
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getCarrier", paramString);
          return true;
          localJSONException = localJSONException;
          aanp.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          aanp.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamt
 * JD-Core Version:    0.7.0.1
 */