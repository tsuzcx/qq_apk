package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class WalletLqtSaveFetchFinishProgressUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtSaveFetchFinishProgressUI$1(WalletLqtSaveFetchFinishProgressUI paramWalletLqtSaveFetchFinishProgressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.qir.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI.1
 * JD-Core Version:    0.7.0.1
 */