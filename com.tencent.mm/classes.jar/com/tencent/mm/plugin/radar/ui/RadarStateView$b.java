package com.tencent.mm.plugin.radar.ui;

import a.d.a.a;
import a.d.b.g;
import a.d.b.h;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class RadarStateView$b
  extends h
  implements a<Animation>
{
  RadarStateView$b(RadarStateView paramRadarStateView)
  {
    super(0);
  }
  
  public static final class a
    implements Animation.AnimationListener
  {
    a(RadarStateView.b paramb) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      g.k(paramAnimation, "animation");
      RadarStateView.b(this.nmQ.nmP);
      this.nmQ.nmP.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.b
 * JD-Core Version:    0.7.0.1
 */