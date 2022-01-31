package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class MMSightRecordButton$3
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$3(MMSightRecordButton paramMMSightRecordButton, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    MMSightRecordButton.a(this.moU, false);
    if (this.moW != null) {
      this.moW.onAnimationEnd(paramAnimator);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    MMSightRecordButton.a(this.moU, true);
    if (this.moW != null) {
      this.moW.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.3
 * JD-Core Version:    0.7.0.1
 */