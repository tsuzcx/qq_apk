package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$1(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45426);
    if (WalletBalanceManagerUI.a(this.tOJ))
    {
      this.tOJ.hideVKB();
      this.tOJ.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(45426);
      return true;
      this.tOJ.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.1
 * JD-Core Version:    0.7.0.1
 */