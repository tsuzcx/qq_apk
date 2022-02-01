package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOfflineCoinPurseUI$9
  implements Runnable
{
  WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(213637);
    ViewGroup.LayoutParams localLayoutParams = WalletOfflineCoinPurseUI.n(this.AMt).getLayoutParams();
    if (localLayoutParams != null) {
      WalletOfflineCoinPurseUI.n(this.AMt).setMinimumHeight(localLayoutParams.height);
    }
    AppMethodBeat.o(213637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9
 * JD-Core Version:    0.7.0.1
 */