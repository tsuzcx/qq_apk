package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SightCaptureUI$27
  implements View.OnClickListener
{
  SightCaptureUI$27(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(94678);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (SightCaptureUI.j(this.zDF) != null) {
      SightCaptureUI.d(this.zDF);
    }
    a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(94678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.27
 * JD-Core Version:    0.7.0.1
 */