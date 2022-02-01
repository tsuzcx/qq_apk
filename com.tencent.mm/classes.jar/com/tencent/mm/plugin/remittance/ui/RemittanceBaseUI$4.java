package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceBaseUI$4
  implements View.OnClickListener
{
  RemittanceBaseUI$4(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67953);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    f.a(this.CrN, this.CrN.mScene, RemittanceBaseUI.f(this.CrN), RemittanceBaseUI.b(this.CrN));
    if (this.CrN.mScene == 1) {
      h.CyF.a(12689, new Object[] { Integer.valueOf(13), Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67953);
      return;
      h.CyF.a(12689, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.4
 * JD-Core Version:    0.7.0.1
 */