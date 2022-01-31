package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.List;

final class WalletLqtSaveFetchUI$17
  implements n.d
{
  WalletLqtSaveFetchUI$17(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.fnd != null)
    {
      this.fnd.bFp();
      if (paramInt >= WalletLqtSaveFetchUI.f(this.qiZ).size()) {
        break label77;
      }
      paramMenuItem = (Bankcard)WalletLqtSaveFetchUI.f(this.qiZ).get(paramInt);
      WalletLqtSaveFetchUI.a(this.qiZ, paramMenuItem.field_bindSerial);
      WalletLqtSaveFetchUI.i(this.qiZ);
      WalletLqtSaveFetchUI.c(this.qiZ).bvr();
    }
    label77:
    do
    {
      return;
      if (WalletLqtSaveFetchUI.h(this.qiZ) == 1)
      {
        WalletLqtSaveFetchUI.j(this.qiZ);
        return;
      }
    } while (WalletLqtSaveFetchUI.h(this.qiZ) != 2);
    WalletLqtSaveFetchUI.j(this.qiZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.17
 * JD-Core Version:    0.7.0.1
 */