package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
public final class RadarStateView$c$a
  implements Animation.AnimationListener
{
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(138687);
    p.h(paramAnimation, "animation");
    AppMethodBeat.o(138687);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(138688);
    p.h(paramAnimation, "animation");
    AppMethodBeat.o(138688);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(138686);
    p.h(paramAnimation, "animation");
    AppMethodBeat.o(138686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.c.a
 * JD-Core Version:    0.7.0.1
 */