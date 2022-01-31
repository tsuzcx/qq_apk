package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WalletBalanceManagerUI$13
  implements View.OnClickListener
{
  WalletBalanceManagerUI$13(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.uxb, Integer.valueOf(-1));
    p.bTK();
    paramView = p.bTL();
    if (paramView.qzd != null) {}
    for (paramView = paramView.qzd.field_lqt_cell_lqt_open_url;; paramView = null)
    {
      if (!bk.bl(paramView)) {
        com.tencent.mm.wallet_core.ui.e.l(this.qhk, paramView, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.13
 * JD-Core Version:    0.7.0.1
 */