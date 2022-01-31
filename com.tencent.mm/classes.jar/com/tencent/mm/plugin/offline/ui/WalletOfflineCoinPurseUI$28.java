package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;

final class WalletOfflineCoinPurseUI$28
  implements Runnable
{
  WalletOfflineCoinPurseUI$28(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(43535);
    c localc = WalletOfflineCoinPurseUI.z(this.pny);
    a.g(localc.mActivity, localc.pmu);
    WalletOfflineCoinPurseUI.H(this.pny);
    AppMethodBeat.o(43535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.28
 * JD-Core Version:    0.7.0.1
 */