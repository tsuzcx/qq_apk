package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class RadarStateView$c
  extends u
  implements a<Animation>
{
  RadarStateView$c(RadarStateView paramRadarStateView)
  {
    super(0);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animation.AnimationListener
  {
    a(RadarStateView paramRadarStateView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(267243);
      s.u(paramAnimation, "animation");
      RadarStateView.b(this.Nty);
      this.Nty.setVisibility(8);
      AppMethodBeat.o(267243);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(267245);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(267245);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(267242);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(267242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.c
 * JD-Core Version:    0.7.0.1
 */