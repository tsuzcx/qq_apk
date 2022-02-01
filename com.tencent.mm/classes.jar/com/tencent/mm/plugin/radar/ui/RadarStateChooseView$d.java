package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/Animation;"}, k=3, mv={1, 5, 1}, xi=48)
final class RadarStateChooseView$d
  extends u
  implements a<Animation>
{
  RadarStateChooseView$d(RadarStateChooseView paramRadarStateChooseView)
  {
    super(0);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138670);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138670);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138671);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138671);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138669);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView.d
 * JD-Core Version:    0.7.0.1
 */