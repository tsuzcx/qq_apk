package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceSaveUI$15
  implements Runnable
{
  WalletBalanceSaveUI$15(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(316338);
    if ((WalletBalanceSaveUI.e(this.Vdh) == 2) && (this.Vdh.isHandleAutoShowNormalStWcKb())) {
      this.Vdh.showNormalStWcKb();
    }
    AppMethodBeat.o(316338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.15
 * JD-Core Version:    0.7.0.1
 */