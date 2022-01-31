package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class SightCaptureUI$15
  extends AnimatorListenerAdapter
{
  SightCaptureUI$15(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    SightCaptureUI.G(this.mqB).setEnabled(true);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    SightCaptureUI.G(this.mqB).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.15
 * JD-Core Version:    0.7.0.1
 */