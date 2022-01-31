package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.sdk.platformtools.ai;

final class i$2
  extends AnimatorListenerAdapter
{
  i$2(j paramj, e parame) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ai.d(new i.2.1(this));
    this.rrJ.onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.2
 * JD-Core Version:    0.7.0.1
 */