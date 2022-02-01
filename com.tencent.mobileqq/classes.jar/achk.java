import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class achk
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacfw != null) {}
    for (paramVarArgs = paramacfw.a(); (paramacfw == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      acho.d("GdtOSVersionJsCall", "handleJsCallRequest error");
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
          paramacfw.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramacfw != null) {
            paramString = paramacfw.a();
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
 * Qualified Name:     achk
 * JD-Core Version:    0.7.0.1
 */