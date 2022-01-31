package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class RemittanceDetailUI$3$1
  implements DialogInterface.OnClickListener
{
  RemittanceDetailUI$3$1(RemittanceDetailUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("transaction_id", this.nDp.nDm.nDd);
    paramDialogInterface.putExtra("receiver_name", RemittanceDetailUI.b(this.nDp.nDm));
    this.nDp.nDm.T(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.3.1
 * JD-Core Version:    0.7.0.1
 */