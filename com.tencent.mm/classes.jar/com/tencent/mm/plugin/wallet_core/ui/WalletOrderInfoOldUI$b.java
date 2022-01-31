package com.tencent.mm.plugin.wallet_core.ui;

import org.json.JSONObject;

final class WalletOrderInfoOldUI$b
{
  public String bQZ;
  public String bVO;
  public String qEu;
  public String title;
  public String url;
  
  public WalletOrderInfoOldUI$b(WalletOrderInfoOldUI paramWalletOrderInfoOldUI, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramWalletOrderInfoOldUI = paramJSONObject.optJSONObject("activity_change_info");
    } while (paramWalletOrderInfoOldUI == null);
    this.url = paramWalletOrderInfoOldUI.optString("url");
    this.bQZ = paramWalletOrderInfoOldUI.optString("wording");
    this.bVO = paramWalletOrderInfoOldUI.optString("icon");
    this.qEu = paramWalletOrderInfoOldUI.optString("btn_text");
    this.title = paramWalletOrderInfoOldUI.optString("title");
  }
  
  public final String toString()
  {
    return this.url + " , " + this.bQZ + " , " + this.bVO + " , " + this.qEu + " , " + this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.b
 * JD-Core Version:    0.7.0.1
 */