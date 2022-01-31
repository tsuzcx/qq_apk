package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PayURemittanceDetailUI$7$1
  implements DialogInterface.OnClickListener
{
  PayURemittanceDetailUI$7$1(PayURemittanceDetailUI.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48550);
    this.uDS.uDP.chy();
    AppMethodBeat.o(48550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.7.1
 * JD-Core Version:    0.7.0.1
 */