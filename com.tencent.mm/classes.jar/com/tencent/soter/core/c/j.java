package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private String BmA = "";
  private String BmB = "";
  private String BmC = "";
  private String BmD = "";
  private String BmE = "";
  public int BmF = 20;
  public String BmG = "";
  private long Bmu = -1L;
  private String Bmy = null;
  public String Bmz = null;
  public String signature = "";
  
  public static j awO(String paramString)
  {
    AppMethodBeat.i(73049);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.BmG = paramString;
      localj.Bmy = localJSONObject.optString("raw");
      localj.Bmz = localJSONObject.optString("fid");
      localj.Bmu = localJSONObject.optLong("counter");
      localj.BmA = localJSONObject.optString("tee_n");
      localj.BmB = localJSONObject.optString("tee_v");
      localj.BmC = localJSONObject.optString("fp_n");
      localj.BmD = localJSONObject.optString("fp_v");
      localj.BmE = localJSONObject.optString("cpu_id");
      localj.BmF = localJSONObject.optInt("rsa_pss_saltlen", 20);
      AppMethodBeat.o(73049);
      return localj;
    }
    catch (JSONException paramString)
    {
      d.e("Soter.SoterSignatureResult", "soter: convert from json failed." + paramString.toString(), new Object[0]);
      AppMethodBeat.o(73049);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73048);
    String str = "SoterSignatureResult{rawValue='" + this.Bmy + '\'' + ", fid='" + this.Bmz + '\'' + ", counter=" + this.Bmu + ", TEEName='" + this.BmA + '\'' + ", TEEVersion='" + this.BmB + '\'' + ", FpName='" + this.BmC + '\'' + ", FpVersion='" + this.BmD + '\'' + ", cpuId='" + this.BmE + '\'' + ", saltLen=" + this.BmF + ", jsonValue='" + this.BmG + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(73048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */