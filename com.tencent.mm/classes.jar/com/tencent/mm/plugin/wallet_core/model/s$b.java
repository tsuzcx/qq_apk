package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s$b
{
  public String uaK;
  public String uaL;
  public String ugl;
  public String uiQ;
  public String uiR;
  public String uiS;
  public int uiT;
  
  public final void aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46791);
    this.uaK = paramJSONObject.optString("tinyapp_name");
    this.uiQ = paramJSONObject.optString("tinyapp_logo");
    this.uiR = paramJSONObject.optString("tinyapp_desc");
    this.ugl = paramJSONObject.optString("tinyapp_username");
    this.uaL = paramJSONObject.optString("tinyapp_path");
    this.uiS = paramJSONObject.optString("activity_tinyapp_btn_text");
    this.uiT = paramJSONObject.optInt("tinyapp_version", 0);
    AppMethodBeat.o(46791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s.b
 * JD-Core Version:    0.7.0.1
 */