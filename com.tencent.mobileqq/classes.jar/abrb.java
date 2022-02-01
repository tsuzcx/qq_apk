import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONObject;

class abrb
  implements abqx
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramabqc != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramabqc.a();
        paramVarArgs = abro.a(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramabqc.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramabqc == null) {
        continue;
      }
      paramString = paramabqc.a();
      paramVarArgs = localObject;
      if (paramabqc != null) {
        paramVarArgs = paramabqc.a();
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
 * Qualified Name:     abrb
 * JD-Core Version:    0.7.0.1
 */