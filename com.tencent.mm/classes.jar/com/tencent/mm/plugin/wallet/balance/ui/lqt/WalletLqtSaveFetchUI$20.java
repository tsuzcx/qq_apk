package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchUI$20
  implements Runnable
{
  WalletLqtSaveFetchUI$20(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(187119);
    if ((WalletLqtSaveFetchUI.x(this.zMe) == 2) && (this.zMe.isHandleAutoShowNormalStWcKb())) {
      this.zMe.showNormalStWcKb();
    }
    AppMethodBeat.o(187119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.20
 * JD-Core Version:    0.7.0.1
 */