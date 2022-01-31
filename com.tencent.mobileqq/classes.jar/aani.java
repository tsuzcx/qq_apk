import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class aani
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramaamm.a();
        paramVarArgs = GdtLocationUtil.INSTANCE.getLocation(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramaamm.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramaamm == null) {
        continue;
      }
      paramString = paramaamm.a();
      paramVarArgs = localObject;
      if (paramaamm != null) {
        paramVarArgs = paramaamm.a();
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
 * Qualified Name:     aani
 * JD-Core Version:    0.7.0.1
 */