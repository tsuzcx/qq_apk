package com.tencent.mm.plugin.order.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$3$1
  implements DialogInterface.OnClickListener
{
  a$3$1(a.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("transaction_id", this.mRk.mOH.bMY);
    paramDialogInterface.putExtra("receiver_name", this.mRk.mOH.mPo);
    paramDialogInterface.putExtra("resend_msg_from_flag", 1);
    d.b(this.mRk.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.3.1
 * JD-Core Version:    0.7.0.1
 */