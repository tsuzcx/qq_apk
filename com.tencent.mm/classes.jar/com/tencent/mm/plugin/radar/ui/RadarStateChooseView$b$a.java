package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class RadarStateChooseView$b$a
  implements Animation.AnimationListener
{
  RadarStateChooseView$b$a(RadarStateChooseView.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    g.k(paramAnimation, "animation");
    RadarStateChooseView.a(this.nmJ.nmI);
    this.nmJ.nmI.setVisibility(8);
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
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView.b.a
 * JD-Core Version:    0.7.0.1
 */