package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletVerifyCodeUI$10
  implements MenuItem.OnMenuItemClickListener
{
  WalletVerifyCodeUI$10(WalletVerifyCodeUI paramWalletVerifyCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(47699);
    this.uul.hideVKB();
    if (this.uul.needConfirmFinish()) {
      this.uul.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(47699);
      return false;
      this.uul.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.10
 * JD-Core Version:    0.7.0.1
 */