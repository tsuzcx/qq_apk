package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class ScanTranslationCaptureUI$5
  extends AnimatorListenerAdapter
{
  ScanTranslationCaptureUI$5(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(81259);
    ScanTranslationCaptureUI.a(this.qAW, false);
    ScanTranslationCaptureUI.a(this.qAW).setVisibility(8);
    AppMethodBeat.o(81259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.5
 * JD-Core Version:    0.7.0.1
 */