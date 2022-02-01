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
    AppMethodBeat.i(120864);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ScanTranslationCaptureUI.r(this.ISv).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ScanTranslationCaptureUI.r(this.ISv).setTranslationY(f * (ScanTranslationCaptureUI.s(this.ISv) - ScanTranslationCaptureUI.r(this.ISv).getHeight()));
      AppMethodBeat.o(120864);
      return;
      if (f >= 0.9F) {
        ScanTranslationCaptureUI.r(this.ISv).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.2
 * JD-Core Version:    0.7.0.1
 */