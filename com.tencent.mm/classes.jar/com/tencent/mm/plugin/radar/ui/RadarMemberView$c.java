package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

public final class RadarMemberView$c
  implements Animation.AnimationListener
{
  public final void onAnimationEnd(Animation paramAnimation)
  {
    g.k(paramAnimation, "animation");
    paramAnimation = RadarMemberView.nmg;
    y.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
    RadarMemberView.e(this.nmh);
    paramAnimation = RadarMemberView.d(this.nmh);
    RadarMemberView.a locala = RadarMemberView.nmg;
    paramAnimation.sendEmptyMessage(RadarMemberView.buG());
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    g.k(paramAnimation, "animation");
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    g.k(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.c
 * JD-Core Version:    0.7.0.1
 */