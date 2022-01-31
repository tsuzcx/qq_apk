package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.b.a;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceFetchUI$18$2
  implements n.d
{
  WalletBalanceFetchUI$18$2(WalletBalanceFetchUI.18 param18) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    if ((this.qgZ.qgY.qth.qtj != null) && (paramInt < this.qgZ.qgY.qth.qtj.length))
    {
      paramMenuItem = this.qgZ.qgY.qth.qtj[paramInt];
      y.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramMenuItem.qho), paramMenuItem.ina });
    }
    switch (paramMenuItem.qho)
    {
    default: 
      return;
    }
    e.l(this.qgZ.qgO.mController.uMN, paramMenuItem.ina, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.18.2
 * JD-Core Version:    0.7.0.1
 */