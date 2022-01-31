package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanHomeUI$8
  implements d.a
{
  WalletLqtPlanHomeUI$8(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, Dialog paramDialog) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(45613);
    this.tQB.dismiss();
    if ((paramObject instanceof o)) {
      ((o)paramObject).y(this.tQV.getContext(), false);
    }
    AppMethodBeat.o(45613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.8
 * JD-Core Version:    0.7.0.1
 */