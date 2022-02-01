package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.cpr;
import org.json.JSONObject;

final class WalletOrderInfoNewUI$a
{
  public String CRv;
  public String CRw;
  public String DfD;
  public String Dpt;
  public String Dpu;
  public String Dpv;
  public String DyN;
  public int DyO;
  public String dEM;
  public String dyI;
  public String title;
  public String url;
  
  public WalletOrderInfoNewUI$a(cpr paramcpr)
  {
    AppMethodBeat.i(71012);
    if ((paramcpr != null) && (paramcpr.HBK != null))
    {
      paramcpr = paramcpr.HBK;
      this.url = paramcpr.url;
      this.dyI = paramcpr.dyI;
      this.dEM = paramcpr.dEM;
      this.DyN = paramcpr.DyN;
      this.title = paramcpr.title;
      this.CRv = paramcpr.CRv;
      this.CRw = paramcpr.CRw;
      this.DyO = paramcpr.DyO;
      this.DfD = this.title;
      this.Dpt = this.dEM;
      this.Dpu = this.dyI;
      this.Dpv = this.DyN;
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
      this.dyI = paramJSONObject.optString("wording");
      this.dEM = paramJSONObject.optString("icon");
      this.DyN = paramJSONObject.optString("btn_text");
      this.title = paramJSONObject.optString("title");
      this.DfD = paramJSONObject.optString("tinyapp_name");
      this.Dpt = paramJSONObject.optString("tinyapp_logo");
      this.Dpu = paramJSONObject.optString("tinyapp_desc");
      this.CRv = paramJSONObject.optString("tinyapp_username");
      this.CRw = paramJSONObject.optString("tinyapp_path");
      this.Dpv = paramJSONObject.optString("activity_tinyapp_btn_text");
    }
    AppMethodBeat.o(71011);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71013);
    String str = this.url + " , " + this.dyI + " , " + this.dEM + " , " + this.DyN + " , " + this.title;
    AppMethodBeat.o(71013);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a
 * JD-Core Version:    0.7.0.1
 */