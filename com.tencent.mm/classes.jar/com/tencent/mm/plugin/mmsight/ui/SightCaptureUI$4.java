package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SightCaptureUI$4
  implements View.OnClickListener
{
  SightCaptureUI$4(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(94635);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!SightCaptureUI.w(this.zDF))
    {
      a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(94635);
      return;
    }
    this.zDF.finish();
    this.zDF.overridePendingTransition(-1, 2130772162);
    a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(94635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.4
 * JD-Core Version:    0.7.0.1
 */