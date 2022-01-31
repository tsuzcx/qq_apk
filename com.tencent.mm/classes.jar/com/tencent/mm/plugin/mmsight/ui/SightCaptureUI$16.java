package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class SightCaptureUI$16
  extends AnimatorListenerAdapter
{
  SightCaptureUI$16(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    SightCaptureUI.Q(this.mqB).setEnabled(true);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    SightCaptureUI.Q(this.mqB).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.16
 * JD-Core Version:    0.7.0.1
 */