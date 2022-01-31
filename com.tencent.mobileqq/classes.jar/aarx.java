import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class aarx
  implements aaru
{
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaarb != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramaarb.a();
        paramVarArgs = GdtLocationUtil.INSTANCE.getLocation(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramaarb.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramaarb == null) {
        continue;
      }
      paramString = paramaarb.a();
      paramVarArgs = localObject;
      if (paramaarb != null) {
        paramVarArgs = paramaarb.a();
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
 * Qualified Name:     aarx
 * JD-Core Version:    0.7.0.1
 */