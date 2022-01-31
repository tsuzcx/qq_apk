package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.h.a.lz;
import com.tencent.mm.sdk.b.a;

final class ScanTranslationCaptureUI$7
  extends AnimatorListenerAdapter
{
  ScanTranslationCaptureUI$7(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new lz();
    paramAnimator.bVf.action = 3;
    a.udP.m(paramAnimator);
    ScanTranslationCaptureUI.a(this.nNm, false);
    ScanTranslationCaptureUI.y(this.nNm);
    this.nNm.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.7
 * JD-Core Version:    0.7.0.1
 */