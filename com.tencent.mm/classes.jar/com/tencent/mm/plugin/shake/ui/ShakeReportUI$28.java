package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ShakeReportUI$28
  implements View.OnClickListener
{
  ShakeReportUI$28(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28480);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ShakeReportUI.i(this.PEm).cancel();
    a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.28
 * JD-Core Version:    0.7.0.1
 */