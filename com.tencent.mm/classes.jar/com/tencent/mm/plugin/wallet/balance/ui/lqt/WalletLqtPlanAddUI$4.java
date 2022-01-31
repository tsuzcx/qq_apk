package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtPlanAddUI$4
  implements d.a
{
  WalletLqtPlanAddUI$4(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Dialog paramDialog) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(45561);
    this.tQB.dismiss();
    if ((paramObject instanceof o)) {
      ((o)paramObject).y(this.tQA.getContext(), false);
    }
    AppMethodBeat.o(45561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.4
 * JD-Core Version:    0.7.0.1
 */