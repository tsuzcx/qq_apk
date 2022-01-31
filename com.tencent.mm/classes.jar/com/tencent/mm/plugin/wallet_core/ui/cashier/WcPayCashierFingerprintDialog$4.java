package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierFingerprintDialog$4
  implements View.OnClickListener
{
  WcPayCashierFingerprintDialog$4(WcPayCashierFingerprintDialog paramWcPayCashierFingerprintDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47827);
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "click switch payway");
    this.uvR.dismiss();
    if (WcPayCashierFingerprintDialog.a(this.uvR) != null) {
      WcPayCashierFingerprintDialog.a(this.uvR).cWB();
    }
    AppMethodBeat.o(47827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.4
 * JD-Core Version:    0.7.0.1
 */