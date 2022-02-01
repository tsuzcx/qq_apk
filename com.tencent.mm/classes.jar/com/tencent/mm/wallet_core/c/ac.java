package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String SLk;
  public String UGe;
  public String Uto;
  public String YVJ;
  public int YVK;
  
  public ac()
  {
    this.SLk = "";
    this.UGe = "";
    this.YVJ = "";
    this.Uto = "";
    this.YVK = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.SLk = "";
    this.UGe = "";
    this.YVJ = "";
    this.Uto = "";
    this.YVK = 0;
    this.SLk = paramJSONObject.optString("device_id");
    this.UGe = paramJSONObject.optString("device_name");
    this.YVJ = paramJSONObject.optString("device_os");
    this.YVK = paramJSONObject.optInt("Is_cur_device");
    this.Uto = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */