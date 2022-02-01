package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletConfirmCardIDUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletConfirmCardIDUI$1(WalletConfirmCardIDUI paramWalletConfirmCardIDUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(70930);
    if (this.Ani.needConfirmFinish())
    {
      this.Ani.hideVKB();
      this.Ani.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(70930);
      return false;
      this.Ani.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.1
 * JD-Core Version:    0.7.0.1
 */