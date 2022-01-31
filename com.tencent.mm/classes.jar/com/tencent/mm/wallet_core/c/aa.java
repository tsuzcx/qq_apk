package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class aa
{
  public String AXm;
  public String AXn;
  public int AXo;
  public String xTJ;
  public String ycL;
  
  public aa()
  {
    this.AXm = "";
    this.ycL = "";
    this.AXn = "";
    this.xTJ = "";
    this.AXo = 0;
  }
  
  public aa(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49092);
    this.AXm = "";
    this.ycL = "";
    this.AXn = "";
    this.xTJ = "";
    this.AXo = 0;
    this.AXm = paramJSONObject.optString("device_id");
    this.ycL = paramJSONObject.optString("device_name");
    this.AXn = paramJSONObject.optString("device_os");
    this.AXo = paramJSONObject.optInt("Is_cur_device");
    this.xTJ = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(49092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.aa
 * JD-Core Version:    0.7.0.1
 */