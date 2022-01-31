package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.sdk.b.a;

final class ScanTranslationCaptureUI$8
  extends AnimatorListenerAdapter
{
  ScanTranslationCaptureUI$8(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(138493);
    paramAnimator = new mq();
    paramAnimator.cCN.action = 3;
    a.ymk.l(paramAnimator);
    ScanTranslationCaptureUI.a(this.qAW, false);
    ScanTranslationCaptureUI.z(this.qAW);
    this.qAW.finish();
    AppMethodBeat.o(138493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.8
 * JD-Core Version:    0.7.0.1
 */