package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private String LQA = "";
  private String LQB = "";
  private String LQC = "";
  public int LQD = 20;
  public String LQE = "";
  private long LQt = -1L;
  public String LQx = null;
  private String LQy = "";
  private String LQz = "";
  private String rawValue = null;
  public String signature = "";
  
  public static j aZw(String paramString)
  {
    AppMethodBeat.i(88677);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.LQE = paramString;
      localj.rawValue = localJSONObject.optString("raw");
      localj.LQx = localJSONObject.optString("fid");
      localj.LQt = localJSONObject.optLong("counter");
      localj.LQy = localJSONObject.optString("tee_n");
      localj.LQz = localJSONObject.optString("tee_v");
      localj.LQA = localJSONObject.optString("fp_n");
      localj.LQB = localJSONObject.optString("fp_v");
      localj.LQC = localJSONObject.optString("cpu_id");
      localj.LQD = localJSONObject.optInt("rsa_pss_saltlen", 20);
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
    String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.LQx + '\'' + ", counter=" + this.LQt + ", TEEName='" + this.LQy + '\'' + ", TEEVersion='" + this.LQz + '\'' + ", FpName='" + this.LQA + '\'' + ", FpVersion='" + this.LQB + '\'' + ", cpuId='" + this.LQC + '\'' + ", saltLen=" + this.LQD + ", jsonValue='" + this.LQE + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88676);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */