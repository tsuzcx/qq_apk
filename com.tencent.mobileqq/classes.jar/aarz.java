import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aarz
  implements aaru
{
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaarb != null) {}
    for (paramVarArgs = paramaarb.a(); (paramaarb == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aase.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("netType", aasg.a(paramVarArgs));
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getNetType", paramString);
          return true;
          localJSONException = localJSONException;
          aase.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          aase.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarz
 * JD-Core Version:    0.7.0.1
 */