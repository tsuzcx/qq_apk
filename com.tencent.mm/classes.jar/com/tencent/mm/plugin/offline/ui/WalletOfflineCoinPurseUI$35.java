package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WalletOfflineCoinPurseUI$35
  implements ap.a
{
  WalletOfflineCoinPurseUI$35(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(43545);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.P(this.pny)) });
    if (WalletOfflineCoinPurseUI.P(this.pny))
    {
      cb localcb = new cb();
      localcb.cpA.bpE = 0;
      a.ymk.l(localcb);
    }
    this.pny.finish();
    AppMethodBeat.o(43545);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.35
 * JD-Core Version:    0.7.0.1
 */