package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String NgK;
  public String Ntg;
  public String Ruk;
  public String Rul;
  public int Rum;
  
  public ac()
  {
    this.Ruk = "";
    this.Ntg = "";
    this.Rul = "";
    this.NgK = "";
    this.Rum = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.Ruk = "";
    this.Ntg = "";
    this.Rul = "";
    this.NgK = "";
    this.Rum = 0;
    this.Ruk = paramJSONObject.optString("device_id");
    this.Ntg = paramJSONObject.optString("device_name");
    this.Rul = paramJSONObject.optString("device_os");
    this.Rum = paramJSONObject.optInt("Is_cur_device");
    this.NgK = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */