package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarTipsView$c
  implements View.OnClickListener
{
  RadarTipsView$c(RadarTipsView paramRadarTipsView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138704);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
    this.xAV.dGJ();
    a.a(this, "com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(138704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView.c
 * JD-Core Version:    0.7.0.1
 */