package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class b$2
  extends AnimatorListenerAdapter
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.mrH.mrt = true;
    if (this.mrH.mru != null) {
      this.mrH.mru.a(this.mrH.mrs);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.mrH.mrt = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b.2
 * JD-Core Version:    0.7.0.1
 */