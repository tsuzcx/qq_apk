package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceFetchUI$16
  implements Runnable
{
  WalletBalanceFetchUI$16(WalletBalanceFetchUI paramWalletBalanceFetchUI, ti paramti) {}
  
  public final void run()
  {
    if (!bk.bl(this.iLQ.ccV.ccW))
    {
      e.a(WalletBalanceFetchUI.i(this.qgO), this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
      return;
    }
    y.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.16
 * JD-Core Version:    0.7.0.1
 */