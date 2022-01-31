package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WalletBalanceManagerUI$12
  implements View.OnClickListener
{
  WalletBalanceManagerUI$12(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.uxb, Integer.valueOf(-1));
    paramView = new Intent(this.qhk, WalletLqtDetailUI.class);
    paramView.putExtra("key_account_type", 1);
    this.qhk.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12
 * JD-Core Version:    0.7.0.1
 */