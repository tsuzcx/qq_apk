package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.am.a;

final class WalletOfflineCoinPurseUI$33
  implements am.a
{
  WalletOfflineCoinPurseUI$33(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean tC()
  {
    WalletOfflineCoinPurseUI.a(this.mNj);
    if ((WalletOfflineCoinPurseUI.o(this.mNj) != null) && (WalletOfflineCoinPurseUI.o(this.mNj).isShowing())) {
      WalletOfflineCoinPurseUI.o(this.mNj).dismiss();
    }
    g.bpT();
    WalletOfflineCoinPurseUI.P(this.mNj);
    if (a.bri()) {
      this.mNj.bql();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.33
 * JD-Core Version:    0.7.0.1
 */