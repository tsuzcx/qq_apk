package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gr;

final class WalletOfflineCoinPurseUI$34
  implements MenuItem.OnMenuItemClickListener
{
  WalletOfflineCoinPurseUI$34(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(43544);
    paramMenuItem = new gr();
    paramMenuItem.cvE.cvF = "ok";
    com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
    if (WalletOfflineCoinPurseUI.c(this.pny) == 8) {
      com.tencent.mm.plugin.offline.c.a.WC(this.pny.getIntent().getStringExtra("key_appid"));
    }
    this.pny.finish();
    AppMethodBeat.o(43544);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.34
 * JD-Core Version:    0.7.0.1
 */