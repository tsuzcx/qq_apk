package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class WalletBalanceManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$1(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (WalletBalanceManagerUI.a(this.qhk))
    {
      this.qhk.XM();
      this.qhk.showDialog(1000);
    }
    for (;;)
    {
      return true;
      this.qhk.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.1
 * JD-Core Version:    0.7.0.1
 */