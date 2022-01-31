package com.tencent.mm.ui.widget.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class c$1$1
  implements Animation.AnimationListener
{
  c$1$1(c.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    c.b(this.wmO.wmN).setVisibility(8);
    c.a(this.wmO.wmN, 0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    c.a(this.wmO.wmN, c.c(this.wmO.wmN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.1.1
 * JD-Core Version:    0.7.0.1
 */