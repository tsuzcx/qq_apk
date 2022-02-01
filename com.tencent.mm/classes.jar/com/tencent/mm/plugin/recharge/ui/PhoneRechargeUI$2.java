package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;

final class PhoneRechargeUI$2
  implements DialogInterface.OnCancelListener
{
  PhoneRechargeUI$2(PhoneRechargeUI paramPhoneRechargeUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(67162);
    g.agi().a(this.cXh);
    AppMethodBeat.o(67162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.2
 * JD-Core Version:    0.7.0.1
 */