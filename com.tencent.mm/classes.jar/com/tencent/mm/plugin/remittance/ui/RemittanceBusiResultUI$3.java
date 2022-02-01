package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;

final class RemittanceBusiResultUI$3
  implements View.OnClickListener
{
  RemittanceBusiResultUI$3(RemittanceBusiResultUI paramRemittanceBusiResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67992);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (RemittanceBusiResultUI.g(this.yrY) == 56) {
      g.yxI.f(19821, new Object[] { Integer.valueOf(10), RemittanceBusiResultUI.h(this.yrY), Integer.valueOf(0) });
    }
    this.yrY.finish();
    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.3
 * JD-Core Version:    0.7.0.1
 */