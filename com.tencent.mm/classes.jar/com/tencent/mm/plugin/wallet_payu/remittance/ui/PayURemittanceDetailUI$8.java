package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$8
  implements DialogInterface.OnClickListener
{
  PayURemittanceDetailUI$8(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48552);
    h.bO(this.uDP.getContext(), this.uDP.getString(2131302549));
    AppMethodBeat.o(48552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */