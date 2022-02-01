package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhoneRechargeUI$10
  implements DialogInterface.OnClickListener
{
  PhoneRechargeUI$10(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(67170);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(67170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.10
 * JD-Core Version:    0.7.0.1
 */