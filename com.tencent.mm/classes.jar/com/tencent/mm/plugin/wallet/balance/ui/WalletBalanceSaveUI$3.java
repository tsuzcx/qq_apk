package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;

final class WalletBalanceSaveUI$3
  implements a
{
  WalletBalanceSaveUI$3(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(45471);
    if (paramBoolean)
    {
      WalletBalanceSaveUI.b(this.tOS);
      AppMethodBeat.o(45471);
      return;
    }
    WalletBalanceSaveUI.c(this.tOS).scrollTo(0, 0);
    AppMethodBeat.o(45471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.3
 * JD-Core Version:    0.7.0.1
 */