package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class WalletBalanceManagerUI$2
  implements View.OnClickListener
{
  WalletBalanceManagerUI$2(WalletBalanceManagerUI paramWalletBalanceManagerUI, am paramam) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68646);
    g.afC();
    g.afB().afk().set(ae.a.FpV, Integer.valueOf(-1));
    com.tencent.mm.wallet_core.ui.e.o(this.zHn, this.zHo.ecR(), true);
    AppMethodBeat.o(68646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.2
 * JD-Core Version:    0.7.0.1
 */