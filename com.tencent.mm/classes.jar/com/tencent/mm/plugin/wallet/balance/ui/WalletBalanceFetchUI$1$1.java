package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class WalletBalanceFetchUI$1$1
  implements n.d
{
  WalletBalanceFetchUI$1$1(WalletBalanceFetchUI.1 param1, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt < this.qgP.size())
    {
      WalletBalanceFetchUI.a(this.qgQ.qgO, (Bankcard)this.qgP.get(paramInt));
      y.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.a(this.qgQ.qgO).field_desc });
    }
    for (;;)
    {
      WalletBalanceFetchUI.c(this.qgQ.qgO);
      return;
      y.i("MicroMsg.WalletBalanceFetchUI", "add new card");
      WalletBalanceFetchUI.b(this.qgQ.qgO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.1.1
 * JD-Core Version:    0.7.0.1
 */