package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanAddUI$4
  implements d.a
{
  WalletLqtPlanAddUI$4(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Dialog paramDialog) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68837);
    this.zIi.dismiss();
    if ((paramObject instanceof m)) {
      ((m)paramObject).A(this.zJT.getContext(), false);
    }
    AppMethodBeat.o(68837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.4
 * JD-Core Version:    0.7.0.1
 */