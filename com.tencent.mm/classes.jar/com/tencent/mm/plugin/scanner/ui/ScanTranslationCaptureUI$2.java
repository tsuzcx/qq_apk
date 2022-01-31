package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanTranslationCaptureUI$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationCaptureUI$2(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(81255);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ScanTranslationCaptureUI.r(this.qAW).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ScanTranslationCaptureUI.r(this.qAW).setTranslationY(f * (ScanTranslationCaptureUI.s(this.qAW) - ScanTranslationCaptureUI.r(this.qAW).getHeight()));
      AppMethodBeat.o(81255);
      return;
      if (f >= 0.9F) {
        ScanTranslationCaptureUI.r(this.qAW).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.2
 * JD-Core Version:    0.7.0.1
 */