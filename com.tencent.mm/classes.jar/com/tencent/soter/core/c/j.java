package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private long ahxh = -1L;
  public String ahxl = null;
  private String ahxm = "";
  private String ahxn = "";
  private String ahxo = "";
  private String ahxp = "";
  private String ahxq = "";
  public int ahxr = 20;
  public String ahxs = "";
  private String rawValue = null;
  public String signature = "";
  
  public static j bFJ(String paramString)
  {
    AppMethodBeat.i(88677);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.ahxs = paramString;
      localj.rawValue = localJSONObject.optString("raw");
      localj.ahxl = localJSONObject.optString("fid");
      localj.ahxh = localJSONObject.optLong("counter");
      localj.ahxm = localJSONObject.optString("tee_n");
      localj.ahxn = localJSONObject.optString("tee_v");
      localj.ahxo = localJSONObject.optString("fp_n");
      localj.ahxp = localJSONObject.optString("fp_v");
      localj.ahxq = localJSONObject.optString("cpu_id");
      localj.ahxr = localJSONObject.optInt("rsa_pss_saltlen", 20);
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
    String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.ahxl + '\'' + ", counter=" + this.ahxh + ", TEEName='" + this.ahxm + '\'' + ", TEEVersion='" + this.ahxn + '\'' + ", FpName='" + this.ahxo + '\'' + ", FpVersion='" + this.ahxp + '\'' + ", cpuId='" + this.ahxq + '\'' + ", saltLen=" + this.ahxr + ", jsonValue='" + this.ahxs + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88676);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */