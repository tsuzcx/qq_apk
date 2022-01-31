package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
public final class RadarMemberView$c
  implements Animation.AnimationListener
{
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(102949);
    j.q(paramAnimation, "animation");
    ab.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
    RadarMemberView.e(this.pRw);
    RadarMemberView.d(this.pRw).sendEmptyMessage(RadarMemberView.ceS());
    AppMethodBeat.o(102949);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(102948);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(102948);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(102947);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(102947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.c
 * JD-Core Version:    0.7.0.1
 */