package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.sdk.platformtools.y;

final class WalletBalanceFetchPwdInputUI$4
  implements o.a
{
  WalletBalanceFetchPwdInputUI$4(WalletBalanceFetchPwdInputUI paramWalletBalanceFetchPwdInputUI) {}
  
  public final void bqo()
  {
    y.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
    WalletBalanceFetchPwdInputUI.a(this.qgp).dismiss();
    this.qgp.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.4
 * JD-Core Version:    0.7.0.1
 */