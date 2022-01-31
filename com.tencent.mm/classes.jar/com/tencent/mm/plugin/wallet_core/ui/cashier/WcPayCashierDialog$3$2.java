package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierDialog$3$2
  implements DialogInterface.OnCancelListener
{
  WcPayCashierDialog$3$2(WcPayCashierDialog.3 param3) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142536);
    ab.i("MicroMsg.WcPayCashierDialog", "on cancel");
    WcPayCashierDialog.a(this.uvG.uvD, null);
    this.uvG.uvD.show();
    AppMethodBeat.o(142536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.3.2
 * JD-Core Version:    0.7.0.1
 */