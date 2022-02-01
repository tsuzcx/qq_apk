package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RechargeUI$12
  implements View.OnClickListener
{
  RechargeUI$12(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67226);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((RechargeUI.b(this.BFe)) && (RechargeUI.c(this.BFe))) {
      RechargeUI.d(this.BFe);
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.12
 * JD-Core Version:    0.7.0.1
 */