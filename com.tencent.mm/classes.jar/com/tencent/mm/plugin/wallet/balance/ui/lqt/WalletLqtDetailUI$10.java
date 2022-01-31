package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class WalletLqtDetailUI$10
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$10(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142294);
    paramMenuItem = new d(this.tPQ, 1, false);
    paramMenuItem.sao = new WalletLqtDetailUI.10.1(this);
    paramMenuItem.sap = new WalletLqtDetailUI.10.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(142294);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.10
 * JD-Core Version:    0.7.0.1
 */