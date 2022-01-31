package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierFingerprintDialog$2
  implements DialogInterface.OnDismissListener
{
  WcPayCashierFingerprintDialog$2(WcPayCashierFingerprintDialog paramWcPayCashierFingerprintDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47825);
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
    paramDialogInterface = WcPayCashierFingerprintDialog.b(this.uvR);
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
    paramDialogInterface.mFC.userCancel();
    WcPayCashierFingerprintDialog.c(this.uvR);
    AppMethodBeat.o(47825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.2
 * JD-Core Version:    0.7.0.1
 */