package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanHomeUI$7
  implements d.a
{
  WalletLqtPlanHomeUI$7(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, Dialog paramDialog) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68933);
    this.zIi.dismiss();
    if ((paramObject instanceof m)) {
      ((m)paramObject).A(this.zKT.getContext(), false);
    }
    AppMethodBeat.o(68933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.7
 * JD-Core Version:    0.7.0.1
 */