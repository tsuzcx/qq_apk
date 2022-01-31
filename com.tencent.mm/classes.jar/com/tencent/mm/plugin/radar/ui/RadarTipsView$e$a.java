package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class RadarTipsView$e$a
  implements Animation.AnimationListener
{
  RadarTipsView$e$a(RadarTipsView.e parame) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    g.k(paramAnimation, "animation");
    if (!RadarTipsView.a(this.nns.nnr)) {
      RadarTipsView.b(this.nns.nnr).sendEmptyMessage(0);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView.e.a
 * JD-Core Version:    0.7.0.1
 */