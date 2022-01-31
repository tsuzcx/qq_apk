package com.tencent.soter.core.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public String signature = "";
  private long wOW = -1L;
  private String wPa = null;
  public String wPb = null;
  private String wPc = "";
  private String wPd = "";
  private String wPe = "";
  private String wPf = "";
  private String wPg = "";
  public int wPh = 20;
  public String wPi = "";
  
  public static j afT(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j localj = new j();
      localj.wPi = paramString;
      localj.wPa = localJSONObject.optString("raw");
      localj.wPb = localJSONObject.optString("fid");
      localj.wOW = localJSONObject.optLong("counter");
      localj.wPc = localJSONObject.optString("tee_n");
      localj.wPd = localJSONObject.optString("tee_v");
      localj.wPe = localJSONObject.optString("fp_n");
      localj.wPf = localJSONObject.optString("fp_v");
      localj.wPg = localJSONObject.optString("cpu_id");
      localj.wPh = localJSONObject.optInt("rsa_pss_saltlen", 20);
      return localj;
    }
    catch (JSONException paramString)
    {
      d.e("Soter.SoterSignatureResult", "soter: convert from json failed." + paramString.toString(), new Object[0]);
    }
    return null;
  }
  
  public final String toString()
  {
    return "SoterSignatureResult{rawValue='" + this.wPa + '\'' + ", fid='" + this.wPb + '\'' + ", counter=" + this.wOW + ", TEEName='" + this.wPc + '\'' + ", TEEVersion='" + this.wPd + '\'' + ", FpName='" + this.wPe + '\'' + ", FpVersion='" + this.wPf + '\'' + ", cpuId='" + this.wPg + '\'' + ", saltLen=" + this.wPh + ", jsonValue='" + this.wPi + '\'' + ", signature='" + this.signature + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.c.j
 * JD-Core Version:    0.7.0.1
 */