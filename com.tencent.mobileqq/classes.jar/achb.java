import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONObject;

class achb
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacfw != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramacfw.a();
        paramVarArgs = achr.a(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramacfw.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramacfw == null) {
        continue;
      }
      paramString = paramacfw.a();
      paramVarArgs = localObject;
      if (paramacfw != null) {
        paramVarArgs = paramacfw.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getLocation", paramVarArgs);
      return true;
      paramVarArgs = null;
      continue;
      localJSONObject.put("lat", JSONObject.NULL);
      localJSONObject.put("lon", JSONObject.NULL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achb
 * JD-Core Version:    0.7.0.1
 */