package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanDetailUI$2
  implements d.a
{
  WalletLqtPlanDetailUI$2(WalletLqtPlanDetailUI paramWalletLqtPlanDetailUI, Dialog paramDialog) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68904);
    this.zIi.dismiss();
    if ((paramObject instanceof m)) {
      ((m)paramObject).A(this.zKw.getContext(), false);
    }
    AppMethodBeat.o(68904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.2
 * JD-Core Version:    0.7.0.1
 */