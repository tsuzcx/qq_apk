import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class aanl
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    for (paramVarArgs = paramaamm.a(); (paramaamm == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      aanp.d("GdtOSVersionJsCall", "handleJsCallRequest error");
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
          paramaamm.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramaamm != null) {
            paramString = paramaamm.a();
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
 * Qualified Name:     aanl
 * JD-Core Version:    0.7.0.1
 */