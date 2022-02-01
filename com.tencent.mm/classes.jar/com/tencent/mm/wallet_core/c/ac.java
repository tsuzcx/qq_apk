package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String EEr;
  public String EsX;
  public String IdZ;
  public String Iea;
  public int Ieb;
  
  public ac()
  {
    this.IdZ = "";
    this.EEr = "";
    this.Iea = "";
    this.EsX = "";
    this.Ieb = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.IdZ = "";
    this.EEr = "";
    this.Iea = "";
    this.EsX = "";
    this.Ieb = 0;
    this.IdZ = paramJSONObject.optString("device_id");
    this.EEr = paramJSONObject.optString("device_name");
    this.Iea = paramJSONObject.optString("device_os");
    this.Ieb = paramJSONObject.optInt("Is_cur_device");
    this.EsX = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */