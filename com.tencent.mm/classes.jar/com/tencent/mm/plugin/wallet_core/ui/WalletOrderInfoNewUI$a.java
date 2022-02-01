package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.cox;
import org.json.JSONObject;

final class WalletOrderInfoNewUI$a
{
  public String CNV;
  public String CXO;
  public String CXP;
  public String CXQ;
  public String CzQ;
  public String CzR;
  public String Dhj;
  public int Dhk;
  public String dDH;
  public String dxD;
  public String title;
  public String url;
  
  public WalletOrderInfoNewUI$a(cox paramcox)
  {
    AppMethodBeat.i(71012);
    if ((paramcox != null) && (paramcox.Hik != null))
    {
      paramcox = paramcox.Hik;
      this.url = paramcox.url;
      this.dxD = paramcox.dxD;
      this.dDH = paramcox.dDH;
      this.Dhj = paramcox.Dhj;
      this.title = paramcox.title;
      this.CzQ = paramcox.CzQ;
      this.CzR = paramcox.CzR;
      this.Dhk = paramcox.Dhk;
      this.CNV = this.title;
      this.CXO = this.dDH;
      this.CXP = this.dxD;
      this.CXQ = this.Dhj;
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
      this.dxD = paramJSONObject.optString("wording");
      this.dDH = paramJSONObject.optString("icon");
      this.Dhj = paramJSONObject.optString("btn_text");
      this.title = paramJSONObject.optString("title");
      this.CNV = paramJSONObject.optString("tinyapp_name");
      this.CXO = paramJSONObject.optString("tinyapp_logo");
      this.CXP = paramJSONObject.optString("tinyapp_desc");
      this.CzQ = paramJSONObject.optString("tinyapp_username");
      this.CzR = paramJSONObject.optString("tinyapp_path");
      this.CXQ = paramJSONObject.optString("activity_tinyapp_btn_text");
    }
    AppMethodBeat.o(71011);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71013);
    String str = this.url + " , " + this.dxD + " , " + this.dDH + " , " + this.Dhj + " , " + this.title;
    AppMethodBeat.o(71013);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a
 * JD-Core Version:    0.7.0.1
 */