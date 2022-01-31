package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayCashierDialog$16
  implements DialogInterface.OnShowListener
{
  WcPayCashierDialog$16(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47780);
    WcPayCashierDialog.n(this.uvD);
    this.uvD.setOnShowListener(null);
    AppMethodBeat.o(47780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.16
 * JD-Core Version:    0.7.0.1
 */