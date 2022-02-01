package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private long IuP = -1L;
  public String IuT = null;
  private String IuU = "";
  private String IuV = "";
  private String IuW = "";
  private String IuX = "";
  private String IuY = "";
  public int IuZ = 20;
  public String Iva = "";
  private String rawValue = null;
  public String signature = "";
  
  public static j aNT(String paramString)
  {
    AppMethodBeat.i(88677);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.Iva = paramString;
      localj.rawValue = localJSONObject.optString("raw");
      localj.IuT = localJSONObject.optString("fid");
      localj.IuP = localJSONObject.optLong("counter");
      localj.IuU = localJSONObject.optString("tee_n");
      localj.IuV = localJSONObject.optString("tee_v");
      localj.IuW = localJSONObject.optString("fp_n");
      localj.IuX = localJSONObject.optString("fp_v");
      localj.IuY = localJSONObject.optString("cpu_id");
      localj.IuZ = localJSONObject.optInt("rsa_pss_saltlen", 20);
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
    String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.IuT + '\'' + ", counter=" + this.IuP + ", TEEName='" + this.IuU + '\'' + ", TEEVersion='" + this.IuV + '\'' + ", FpName='" + this.IuW + '\'' + ", FpVersion='" + this.IuX + '\'' + ", cpuId='" + this.IuY + '\'' + ", saltLen=" + this.IuZ + ", jsonValue='" + this.Iva + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88676);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */