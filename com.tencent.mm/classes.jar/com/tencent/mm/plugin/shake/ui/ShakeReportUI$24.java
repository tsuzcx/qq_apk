package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ShakeReportUI$24
  implements View.OnClickListener
{
  ShakeReportUI$24(ShakeReportUI paramShakeReportUI)
  {
    AppMethodBeat.i(161437);
    AppMethodBeat.o(161437);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273552);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ShakeReportUI.a(this.PEm, paramView);
    a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.24
 * JD-Core Version:    0.7.0.1
 */