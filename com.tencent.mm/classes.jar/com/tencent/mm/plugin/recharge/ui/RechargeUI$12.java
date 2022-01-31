package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RechargeUI$12
  implements View.OnClickListener
{
  RechargeUI$12(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44318);
    if ((RechargeUI.b(this.pWS)) && (RechargeUI.c(this.pWS))) {
      RechargeUI.d(this.pWS);
    }
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.12
 * JD-Core Version:    0.7.0.1
 */