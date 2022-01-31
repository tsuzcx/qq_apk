package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierDialog$9
  implements DialogInterface.OnDismissListener
{
  WcPayCashierDialog$9(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47773);
    ab.i("MicroMsg.WcPayCashierDialog", "on dismissed");
    WcPayCashierDialog.b(this.uvD);
    WcPayCashierDialog.d(this.uvD);
    AppMethodBeat.o(47773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.9
 * JD-Core Version:    0.7.0.1
 */