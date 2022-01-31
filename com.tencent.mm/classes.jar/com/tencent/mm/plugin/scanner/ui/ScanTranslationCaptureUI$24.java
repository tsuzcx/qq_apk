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
    AppMethodBeat.i(81282);
    ScanTranslationCaptureUI.r(this.qAW).setAlpha(0.0F);
    AppMethodBeat.o(81282);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(81281);
    ScanTranslationCaptureUI.r(this.qAW).setAlpha(0.0F);
    AppMethodBeat.o(81281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.24
 * JD-Core Version:    0.7.0.1
 */