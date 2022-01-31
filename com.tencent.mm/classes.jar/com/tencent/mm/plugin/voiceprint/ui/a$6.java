package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class a$6
  implements Animation.AnimationListener
{
  a$6(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.pNb != null) {
      this.pNb.bPj();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    if (this.pNb != null) {
      this.pNb.bPi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.6
 * JD-Core Version:    0.7.0.1
 */