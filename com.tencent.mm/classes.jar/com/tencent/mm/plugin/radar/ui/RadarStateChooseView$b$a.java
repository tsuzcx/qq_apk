package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
public final class RadarStateChooseView$b$a
  implements Animation.AnimationListener
{
  RadarStateChooseView$b$a(RadarStateChooseView.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(103018);
    j.q(paramAnimation, "animation");
    RadarStateChooseView.a(this.pRX.pRW);
    this.pRX.pRW.setVisibility(8);
    AppMethodBeat.o(103018);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(103019);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103019);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(103017);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView.b.a
 * JD-Core Version:    0.7.0.1
 */