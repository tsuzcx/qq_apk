package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanTranslationCaptureUI$24
  extends AnimatorListenerAdapter
{
  ScanTranslationCaptureUI$24(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(120891);
    ScanTranslationCaptureUI.r(this.ISv).setAlpha(0.0F);
    AppMethodBeat.o(120891);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(120890);
    ScanTranslationCaptureUI.r(this.ISv).setAlpha(0.0F);
    AppMethodBeat.o(120890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.24
 * JD-Core Version:    0.7.0.1
 */