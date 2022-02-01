package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.drk;
import org.json.JSONObject;

final class WalletOrderInfoNewUI$a
{
  public String ODu;
  public String OQH;
  public String OQI;
  public String OQJ;
  public String Ooe;
  public String Oof;
  public String Pap;
  public int Paq;
  public String icon;
  public String title;
  public String url;
  public String wording;
  
  public WalletOrderInfoNewUI$a(drk paramdrk)
  {
    AppMethodBeat.i(71012);
    if ((paramdrk != null) && (paramdrk.TYs != null))
    {
      paramdrk = paramdrk.TYs;
      this.url = paramdrk.url;
      this.wording = paramdrk.wording;
      this.icon = paramdrk.icon;
      this.Pap = paramdrk.Pap;
      this.title = paramdrk.title;
      this.Ooe = paramdrk.Ooe;
      this.Oof = paramdrk.Oof;
      this.Paq = paramdrk.Paq;
      this.ODu = this.title;
      this.OQH = this.icon;
      this.OQI = this.wording;
      this.OQJ = this.Pap;
    }
    AppMethodBeat.o(71012);
  }
  
  public WalletOrderInfoNewUI$a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71011);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(71011);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("activity_change_info");
    if (paramJSONObject != null)
    {
      this.url = paramJSONObject.optString("url");
      this.wording = paramJSONObject.optString("wording");
      this.icon = paramJSONObject.optString("icon");
      this.Pap = paramJSONObject.optString("btn_text");
      this.title = paramJSONObject.optString("title");
      this.ODu = paramJSONObject.optString("tinyapp_name");
      this.OQH = paramJSONObject.optString("tinyapp_logo");
      this.OQI = paramJSONObject.optString("tinyapp_desc");
      this.Ooe = paramJSONObject.optString("tinyapp_username");
      this.Oof = paramJSONObject.optString("tinyapp_path");
      this.OQJ = paramJSONObject.optString("activity_tinyapp_btn_text");
    }
    AppMethodBeat.o(71011);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71013);
    String str = this.url + " , " + this.wording + " , " + this.icon + " , " + this.Pap + " , " + this.title;
    AppMethodBeat.o(71013);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a
 * JD-Core Version:    0.7.0.1
 */