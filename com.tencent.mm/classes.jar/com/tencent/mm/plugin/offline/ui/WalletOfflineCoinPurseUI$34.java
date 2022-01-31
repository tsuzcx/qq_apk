package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.a.gm;

final class WalletOfflineCoinPurseUI$34
  implements MenuItem.OnMenuItemClickListener
{
  WalletOfflineCoinPurseUI$34(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new gm();
    paramMenuItem.bOm.bOn = "ok";
    com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
    if (WalletOfflineCoinPurseUI.c(this.mNj) == 8) {
      com.tencent.mm.plugin.offline.c.a.KA(this.mNj.getIntent().getStringExtra("key_appid"));
    }
    this.mNj.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.34
 * JD-Core Version:    0.7.0.1
 */