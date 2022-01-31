package com.tencent.mm.ui.widget.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class c$1$2
  implements Animation.AnimationListener
{
  c$1$2(c.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    c.b(this.wmO.wmN).setVisibility(0);
    c.a(this.wmO.wmN, 8);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    c.a(this.wmO.wmN, c.e(this.wmO.wmN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.1.2
 * JD-Core Version:    0.7.0.1
 */