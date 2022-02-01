package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private long RPO = -1L;
  public String RPS = null;
  private String RPT = "";
  private String RPU = "";
  private String RPV = "";
  private String RPW = "";
  private String RPX = "";
  public int RPY = 20;
  public String RPZ = "";
  private String rawValue = null;
  public String signature = "";
  
  public static j bql(String paramString)
  {
    AppMethodBeat.i(88677);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.RPZ = paramString;
      localj.rawValue = localJSONObject.optString("raw");
      localj.RPS = localJSONObject.optString("fid");
      localj.RPO = localJSONObject.optLong("counter");
      localj.RPT = localJSONObject.optString("tee_n");
      localj.RPU = localJSONObject.optString("tee_v");
      localj.RPV = localJSONObject.optString("fp_n");
      localj.RPW = localJSONObject.optString("fp_v");
      localj.RPX = localJSONObject.optString("cpu_id");
      localj.RPY = localJSONObject.optInt("rsa_pss_saltlen", 20);
      AppMethodBeat.o(88677);
      return localj;
    }
    catch (JSONException paramString)
    {
      d.e("Soter.SoterSignatureResult", "soter: convert from json failed." + paramString.toString(), new Object[0]);
      AppMethodBeat.o(88677);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(88676);
    String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.RPS + '\'' + ", counter=" + this.RPO + ", TEEName='" + this.RPT + '\'' + ", TEEVersion='" + this.RPU + '\'' + ", FpName='" + this.RPV + '\'' + ", FpVersion='" + this.RPW + '\'' + ", cpuId='" + this.RPX + '\'' + ", saltLen=" + this.RPY + ", jsonValue='" + this.RPZ + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88676);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */