package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s$a
{
  public String name;
  public String pvi;
  public String title;
  public int type;
  public String uiO;
  public String uiP;
  public String url;
  
  public final void aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46790);
    this.url = paramJSONObject.optString("url");
    this.name = paramJSONObject.optString("wording");
    this.pvi = paramJSONObject.optString("icon");
    this.uiO = paramJSONObject.optString("btn_text");
    this.type = paramJSONObject.optInt("type");
    this.title = paramJSONObject.optString("title");
    this.uiP = paramJSONObject.optString("small_title");
    AppMethodBeat.o(46790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s.a
 * JD-Core Version:    0.7.0.1
 */