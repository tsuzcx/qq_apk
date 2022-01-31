package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class WalletBalanceFetchUI$18
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceFetchUI$18(WalletBalanceFetchUI paramWalletBalanceFetchUI, b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.qgO.mController.uMN, 1, false);
    paramMenuItem.phH = new WalletBalanceFetchUI.18.1(this);
    paramMenuItem.phI = new WalletBalanceFetchUI.18.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.18
 * JD-Core Version:    0.7.0.1
 */