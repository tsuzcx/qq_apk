package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class b$2
  implements Animation.AnimationListener
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.oMj.ovC = false;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.oMj.ovC = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.2
 * JD-Core Version:    0.7.0.1
 */