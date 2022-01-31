package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayCashierFingerprintDialog$1
  implements DialogInterface.OnCancelListener
{
  WcPayCashierFingerprintDialog$1(WcPayCashierFingerprintDialog paramWcPayCashierFingerprintDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47824);
    if (WcPayCashierFingerprintDialog.a(this.uvR) != null) {
      WcPayCashierFingerprintDialog.a(this.uvR).cWA();
    }
    AppMethodBeat.o(47824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.1
 * JD-Core Version:    0.7.0.1
 */