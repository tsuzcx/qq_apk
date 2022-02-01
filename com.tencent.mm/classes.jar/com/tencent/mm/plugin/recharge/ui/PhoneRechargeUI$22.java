package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class PhoneRechargeUI$22
  implements DialogInterface.OnClickListener
{
  PhoneRechargeUI$22(PhoneRechargeUI paramPhoneRechargeUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(67184);
    if (paramInt == -2) {
      h.vKh.f(17623, new Object[] { Integer.valueOf(this.fpl), Integer.valueOf(2) });
    }
    AppMethodBeat.o(67184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.22
 * JD-Core Version:    0.7.0.1
 */