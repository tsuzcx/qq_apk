package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchFinishProgressUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtSaveFetchFinishProgressUI$1(WalletLqtSaveFetchFinishProgressUI paramWalletLqtSaveFetchFinishProgressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68957);
    this.HAA.finish();
    AppMethodBeat.o(68957);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI.1
 * JD-Core Version:    0.7.0.1
 */