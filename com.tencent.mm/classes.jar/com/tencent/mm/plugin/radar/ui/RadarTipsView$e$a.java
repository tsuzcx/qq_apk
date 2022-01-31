package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
public final class RadarTipsView$e$a
  implements Animation.AnimationListener
{
  RadarTipsView$e$a(RadarTipsView.e parame) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(103057);
    j.q(paramAnimation, "animation");
    if (!RadarTipsView.b(this.pSG.pSF)) {
      RadarTipsView.c(this.pSG.pSF).sendEmptyMessage(0);
    }
    AppMethodBeat.o(103057);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(103058);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103058);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(103056);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView.e.a
 * JD-Core Version:    0.7.0.1
 */