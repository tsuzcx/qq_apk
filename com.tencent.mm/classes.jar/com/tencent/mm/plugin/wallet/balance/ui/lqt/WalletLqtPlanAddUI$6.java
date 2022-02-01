package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanAddUI$6
  implements d.a
{
  WalletLqtPlanAddUI$6(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Dialog paramDialog) {}
  
  public final void cm(Object paramObject)
  {
    AppMethodBeat.i(68839);
    this.OoW.dismiss();
    if ((paramObject instanceof m)) {
      ((m)paramObject).L(this.Ora.getContext(), false);
    }
    AppMethodBeat.o(68839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.6
 * JD-Core Version:    0.7.0.1
 */