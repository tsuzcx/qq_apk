package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.h.a.by;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class WalletOfflineCoinPurseUI$35
  implements am.a
{
  WalletOfflineCoinPurseUI$35(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Q(this.mNj)) });
    if (WalletOfflineCoinPurseUI.Q(this.mNj))
    {
      by localby = new by();
      localby.bIf.aYY = 0;
      a.udP.m(localby);
    }
    this.mNj.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.35
 * JD-Core Version:    0.7.0.1
 */