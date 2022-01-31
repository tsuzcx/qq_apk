package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class WalletLqtPlanAddUI$7
  implements b.a
{
  WalletLqtPlanAddUI$7(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142309);
    this.jxY.hide();
    if (paramBoolean)
    {
      WalletLqtPlanAddUI.j(this.tQA).eel = (this.jxY.dPp() + 1);
      WalletLqtPlanAddUI.m(this.tQA);
      WalletLqtPlanAddUI.a(this.tQA);
    }
    AppMethodBeat.o(142309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.7
 * JD-Core Version:    0.7.0.1
 */