package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PayURemittanceDetailUI$1$1
  implements DialogInterface.OnClickListener
{
  PayURemittanceDetailUI$1$1(PayURemittanceDetailUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48542);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("transaction_id", PayURemittanceDetailUI.a(this.uDQ.uDP));
    paramDialogInterface.putExtra("receiver_name", PayURemittanceDetailUI.b(this.uDQ.uDP));
    paramDialogInterface.putExtra("total_fee", PayURemittanceDetailUI.c(this.uDQ.uDP));
    paramDialogInterface.putExtra("fee_type", PayURemittanceDetailUI.d(this.uDQ.uDP));
    this.uDQ.uDP.am(paramDialogInterface);
    AppMethodBeat.o(48542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.1.1
 * JD-Core Version:    0.7.0.1
 */