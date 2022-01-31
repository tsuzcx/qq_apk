package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class au$7
  implements Animation.AnimationListener
{
  boolean oXl = false;
  
  au$7(au paramau, LinearLayout paramLinearLayout, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.oXm != null) {
      this.oXm.setPressed(false);
    }
    if (!this.oXl)
    {
      this.oXl = true;
      if (((this.pep.bER instanceof t)) && (((t)this.pep.bER).bHw())) {
        this.pep.peb.notifyDataSetChanged();
      }
    }
    if (this.per != null) {
      this.per.run();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.7
 * JD-Core Version:    0.7.0.1
 */