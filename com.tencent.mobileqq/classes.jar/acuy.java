import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class acuy
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacts != null) {}
    for (paramVarArgs = paramacts.a(); (paramacts == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      acvc.d("GdtOSVersionJsCall", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("osVersion", Build.VERSION.RELEASE);
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getOSVersion", paramString);
          return true;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuy
 * JD-Core Version:    0.7.0.1
 */