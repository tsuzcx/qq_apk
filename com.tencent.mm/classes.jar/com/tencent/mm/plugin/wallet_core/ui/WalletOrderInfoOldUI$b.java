package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class WalletOrderInfoOldUI$b
{
  public String cDz;
  public String cyA;
  public String title;
  public String urC;
  public String url;
  
  public WalletOrderInfoOldUI$b(WalletOrderInfoOldUI paramWalletOrderInfoOldUI, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47491);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(47491);
      return;
    }
    paramWalletOrderInfoOldUI = paramJSONObject.optJSONObject("activity_change_info");
    if (paramWalletOrderInfoOldUI != null)
    {
      this.url = paramWalletOrderInfoOldUI.optString("url");
      this.cyA = paramWalletOrderInfoOldUI.optString("wording");
      this.cDz = paramWalletOrderInfoOldUI.optString("icon");
      this.urC = paramWalletOrderInfoOldUI.optString("btn_text");
      this.title = paramWalletOrderInfoOldUI.optString("title");
    }
    AppMethodBeat.o(47491);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(47492);
    String str = this.url + " , " + this.cyA + " , " + this.cDz + " , " + this.urC + " , " + this.title;
    AppMethodBeat.o(47492);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.b
 * JD-Core Version:    0.7.0.1
 */