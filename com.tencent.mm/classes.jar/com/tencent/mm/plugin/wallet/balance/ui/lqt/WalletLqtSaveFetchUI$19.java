package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.p.a;

final class WalletLqtSaveFetchUI$19
  implements p.a
{
  WalletLqtSaveFetchUI$19(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void cQP()
  {
    AppMethodBeat.i(142337);
    this.tRZ.cRr();
    if (WalletLqtSaveFetchUI.e(this.tRZ) == 1)
    {
      WalletLqtSaveFetchUI.f(this.tRZ).post(new WalletLqtSaveFetchUI.19.1(this));
      AppMethodBeat.o(142337);
      return;
    }
    WalletLqtSaveFetchUI.e(this.tRZ);
    AppMethodBeat.o(142337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.19
 * JD-Core Version:    0.7.0.1
 */