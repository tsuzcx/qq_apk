package com.tencent.mm.plugin.order.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$3$1
  implements DialogInterface.OnClickListener
{
  a$3$1(a.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43886);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("transaction_id", this.prx.poX.cnJ);
    paramDialogInterface.putExtra("receiver_name", this.prx.poX.ppE);
    paramDialogInterface.putExtra("resend_msg_from_flag", 1);
    d.b(this.prx.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramDialogInterface);
    AppMethodBeat.o(43886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.3.1
 * JD-Core Version:    0.7.0.1
 */