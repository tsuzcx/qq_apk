package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class WalletLqtSaveFetchUI$5$2
  implements n.d
{
  WalletLqtSaveFetchUI$5$2(WalletLqtSaveFetchUI.5 param5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    if (paramInt < this.qjb.qja.size())
    {
      paramMenuItem = ((java.lang.String)this.qjb.qja.get(paramInt)).split("\\|\\|")[1];
      e.l(this.qjb.qiZ, paramMenuItem, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.5.2
 * JD-Core Version:    0.7.0.1
 */