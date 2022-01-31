package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WalletBalanceManagerUI$15
  implements View.OnClickListener
{
  WalletBalanceManagerUI$15(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45441);
    g.RM();
    g.RL().Ru().set(ac.a.yHk, Integer.valueOf(-1));
    paramView = new Intent(this.tOJ, WalletLqtDetailUI.class);
    paramView.putExtra("key_account_type", 1);
    this.tOJ.startActivity(paramView);
    AppMethodBeat.o(45441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.15
 * JD-Core Version:    0.7.0.1
 */