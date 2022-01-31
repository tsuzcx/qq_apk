package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;

final class j$2
  extends AnimatorListenerAdapter
{
  j$2(j paramj) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (j.d(this.rsc) != null) {
      j.d(this.rsc).onAnimationEnd(paramAnimator);
    }
    this.rsc.setVisibility(8);
    if ((j.e(this.rsc) != null) && (!j.e(this.rsc).isRecycled())) {
      j.e(this.rsc).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j.2
 * JD-Core Version:    0.7.0.1
 */