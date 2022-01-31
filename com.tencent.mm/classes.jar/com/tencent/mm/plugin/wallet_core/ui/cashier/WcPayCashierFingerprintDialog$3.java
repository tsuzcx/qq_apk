package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierFingerprintDialog$3
  implements View.OnClickListener
{
  WcPayCashierFingerprintDialog$3(WcPayCashierFingerprintDialog paramWcPayCashierFingerprintDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47826);
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
    this.uvR.cancel();
    AppMethodBeat.o(47826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.3
 * JD-Core Version:    0.7.0.1
 */