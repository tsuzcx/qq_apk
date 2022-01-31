package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceSaveUI$6
  implements Runnable
{
  WalletBalanceSaveUI$6(WalletBalanceSaveUI paramWalletBalanceSaveUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(45476);
    WalletBalanceSaveUI.c(this.tOS).scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(45476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.6
 * JD-Core Version:    0.7.0.1
 */