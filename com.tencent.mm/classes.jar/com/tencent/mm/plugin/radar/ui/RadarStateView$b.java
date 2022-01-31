package com.tencent.mm.plugin.radar.ui;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
final class RadarStateView$b
  extends k
  implements a<Animation>
{
  RadarStateView$b(RadarStateView paramRadarStateView)
  {
    super(0);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class a
    implements Animation.AnimationListener
  {
    a(RadarStateView.b paramb) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(103034);
      j.q(paramAnimation, "animation");
      RadarStateView.b(this.pSe.pSd);
      this.pSe.pSd.setVisibility(8);
      AppMethodBeat.o(103034);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(103035);
      j.q(paramAnimation, "animation");
      AppMethodBeat.o(103035);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(103033);
      j.q(paramAnimation, "animation");
      AppMethodBeat.o(103033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.b
 * JD-Core Version:    0.7.0.1
 */