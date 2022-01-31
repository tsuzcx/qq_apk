package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class WalletLqtDetailUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$4(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.qil, 1, false);
    paramMenuItem.phH = new WalletLqtDetailUI.4.1(this);
    paramMenuItem.phI = new WalletLqtDetailUI.4.2(this);
    paramMenuItem.cfU();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4
 * JD-Core Version:    0.7.0.1
 */