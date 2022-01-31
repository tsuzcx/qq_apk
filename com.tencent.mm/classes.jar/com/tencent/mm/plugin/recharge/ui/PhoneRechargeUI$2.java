package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class PhoneRechargeUI$2
  implements DialogInterface.OnCancelListener
{
  PhoneRechargeUI$2(PhoneRechargeUI paramPhoneRechargeUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(44253);
    g.Rc().a(this.ckS);
    AppMethodBeat.o(44253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.2
 * JD-Core Version:    0.7.0.1
 */