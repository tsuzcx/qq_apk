package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

final class ScanTranslationCaptureUI$23
  extends AnimatorListenerAdapter
{
  ScanTranslationCaptureUI$23(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ScanTranslationCaptureUI.q(this.nNm).setAlpha(0.0F);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    ScanTranslationCaptureUI.q(this.nNm).setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.23
 * JD-Core Version:    0.7.0.1
 */