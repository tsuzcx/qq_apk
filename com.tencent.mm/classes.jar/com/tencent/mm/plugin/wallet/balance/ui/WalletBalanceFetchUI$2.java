package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.i;

final class WalletBalanceFetchUI$2
  implements d
{
  WalletBalanceFetchUI$2(WalletBalanceFetchUI paramWalletBalanceFetchUI, i parami, y paramy) {}
  
  public final void bTn()
  {
    if (this.qgR.cMu()) {
      WalletBalanceFetchUI.j(this.qgO);
    }
  }
  
  public final void bTo()
  {
    if (this.qgR.cMu()) {
      this.qgO.finish();
    }
  }
  
  public final void onCancel()
  {
    if (this.qgR.cMu()) {
      this.qgO.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.2
 * JD-Core Version:    0.7.0.1
 */