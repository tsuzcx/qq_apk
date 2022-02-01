package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ShakeReportUI$5
  implements View.OnClickListener
{
  ShakeReportUI$5(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28451);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ShakeReportUI.s(this.Dlj).cancel();
    a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.5
 * JD-Core Version:    0.7.0.1
 */