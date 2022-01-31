package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhoneRechargeUI$9
  implements DialogInterface.OnClickListener
{
  PhoneRechargeUI$9(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44260);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(44260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.9
 * JD-Core Version:    0.7.0.1
 */