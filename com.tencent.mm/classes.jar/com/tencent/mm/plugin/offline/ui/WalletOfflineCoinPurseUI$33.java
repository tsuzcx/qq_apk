package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WalletOfflineCoinPurseUI$33
  implements ap.a
{
  WalletOfflineCoinPurseUI$33(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(43543);
    WalletOfflineCoinPurseUI.a(this.pny);
    if ((WalletOfflineCoinPurseUI.o(this.pny) != null) && (WalletOfflineCoinPurseUI.o(this.pny).isShowing())) {
      WalletOfflineCoinPurseUI.o(this.pny).dismiss();
    }
    g.bYA();
    WalletOfflineCoinPurseUI.O(this.pny);
    if (a.bZX()) {
      this.pny.bYR();
    }
    AppMethodBeat.o(43543);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.33
 * JD-Core Version:    0.7.0.1
 */