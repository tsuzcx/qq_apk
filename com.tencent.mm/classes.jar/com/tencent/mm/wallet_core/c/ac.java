package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String FPZ;
  public String GbE;
  public String JFB;
  public String JFC;
  public int JFD;
  
  public ac()
  {
    this.JFB = "";
    this.GbE = "";
    this.JFC = "";
    this.FPZ = "";
    this.JFD = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.JFB = "";
    this.GbE = "";
    this.JFC = "";
    this.FPZ = "";
    this.JFD = 0;
    this.JFB = paramJSONObject.optString("device_id");
    this.GbE = paramJSONObject.optString("device_name");
    this.JFC = paramJSONObject.optString("device_os");
    this.JFD = paramJSONObject.optInt("Is_cur_device");
    this.FPZ = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */