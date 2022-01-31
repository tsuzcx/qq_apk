package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RechargeUI$14
  implements View.OnClickListener
{
  RechargeUI$14(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44320);
    if (((RechargeUI.f(this.pWS) != null) && (RechargeUI.f(this.pWS).getCount() > 0)) || ((RechargeUI.g(this.pWS) != null) && (RechargeUI.g(this.pWS).getCount() > 0))) {
      this.pWS.showDialog(1);
    }
    AppMethodBeat.o(44320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.14
 * JD-Core Version:    0.7.0.1
 */