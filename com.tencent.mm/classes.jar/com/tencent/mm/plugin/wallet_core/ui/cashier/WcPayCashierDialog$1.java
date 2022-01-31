package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierDialog$1
  implements DialogInterface.OnCancelListener
{
  WcPayCashierDialog$1(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47757);
    ab.i("MicroMsg.WcPayCashierDialog", "on canceled");
    WcPayCashierDialog.b(this.uvD);
    if (WcPayCashierDialog.c(this.uvD) != null) {
      WcPayCashierDialog.c(this.uvD).onCancel();
    }
    AppMethodBeat.o(47757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.1
 * JD-Core Version:    0.7.0.1
 */