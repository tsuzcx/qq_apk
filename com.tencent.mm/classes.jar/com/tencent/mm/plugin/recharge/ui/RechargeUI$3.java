package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class RechargeUI$3
  implements DialogInterface.OnCancelListener
{
  RechargeUI$3(RechargeUI paramRechargeUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(67218);
    g.agS();
    g.agQ().ghe.a(this.cXh);
    AppMethodBeat.o(67218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.3
 * JD-Core Version:    0.7.0.1
 */