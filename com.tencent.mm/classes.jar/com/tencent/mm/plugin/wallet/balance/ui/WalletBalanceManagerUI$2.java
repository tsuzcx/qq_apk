package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WalletBalanceManagerUI$2
  implements View.OnClickListener
{
  WalletBalanceManagerUI$2(WalletBalanceManagerUI paramWalletBalanceManagerUI, am paramam) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142279);
    g.RM();
    g.RL().Ru().set(ac.a.yHk, Integer.valueOf(-1));
    com.tencent.mm.wallet_core.ui.e.m(this.tOJ, this.tOK.cUx(), true);
    AppMethodBeat.o(142279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.2
 * JD-Core Version:    0.7.0.1
 */