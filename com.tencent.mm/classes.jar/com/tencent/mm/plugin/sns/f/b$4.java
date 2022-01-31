package com.tencent.mm.plugin.sns.f;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class b$4
  implements Animation.AnimationListener
{
  b$4(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.ovQ.ovC = false;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.ovQ.ovC = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.b.4
 * JD-Core Version:    0.7.0.1
 */