package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
public final class RadarStateView$c$a
  implements Animation.AnimationListener
{
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(103038);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103038);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(103039);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103039);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(103037);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(103037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.c.a
 * JD-Core Version:    0.7.0.1
 */