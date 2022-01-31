package com.tencent.mm.plugin.wallet_core.ui.cashier;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WcPayCashierDialog$11
  implements EditHintPasswdView.a
{
  WcPayCashierDialog$11(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47775);
    if (paramBoolean)
    {
      WcPayCashierDialog.a(this.uvD, WcPayCashierDialog.e(this.uvD).getText(), this.uvD.tVQ);
      h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    AppMethodBeat.o(47775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.11
 * JD-Core Version:    0.7.0.1
 */