package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public String JWC = null;
  private String JWD = "";
  private String JWE = "";
  private String JWF = "";
  private String JWG = "";
  private String JWH = "";
  public int JWI = 20;
  public String JWJ = "";
  private long JWy = -1L;
  private String rawValue = null;
  public String signature = "";
  
  public static j aTw(String paramString)
  {
    AppMethodBeat.i(88677);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.JWJ = paramString;
      localj.rawValue = localJSONObject.optString("raw");
      localj.JWC = localJSONObject.optString("fid");
      localj.JWy = localJSONObject.optLong("counter");
      localj.JWD = localJSONObject.optString("tee_n");
      localj.JWE = localJSONObject.optString("tee_v");
      localj.JWF = localJSONObject.optString("fp_n");
      localj.JWG = localJSONObject.optString("fp_v");
      localj.JWH = localJSONObject.optString("cpu_id");
      localj.JWI = localJSONObject.optInt("rsa_pss_saltlen", 20);
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
    String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.JWC + '\'' + ", counter=" + this.JWy + ", TEEName='" + this.JWD + '\'' + ", TEEVersion='" + this.JWE + '\'' + ", FpName='" + this.JWF + '\'' + ", FpVersion='" + this.JWG + '\'' + ", cpuId='" + this.JWH + '\'' + ", saltLen=" + this.JWI + ", jsonValue='" + this.JWJ + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88676);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */