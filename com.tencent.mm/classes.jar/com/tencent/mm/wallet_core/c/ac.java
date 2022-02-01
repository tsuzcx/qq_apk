package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String HUr;
  public String IgI;
  public String LVu;
  public String LVv;
  public int LVw;
  
  public ac()
  {
    this.LVu = "";
    this.IgI = "";
    this.LVv = "";
    this.HUr = "";
    this.LVw = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.LVu = "";
    this.IgI = "";
    this.LVv = "";
    this.HUr = "";
    this.LVw = 0;
    this.LVu = paramJSONObject.optString("device_id");
    this.IgI = paramJSONObject.optString("device_name");
    this.LVv = paramJSONObject.optString("device_os");
    this.LVw = paramJSONObject.optInt("Is_cur_device");
    this.HUr = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */