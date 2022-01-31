package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanTranslationCaptureUI$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationCaptureUI$4(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(81258);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = ScanTranslationCaptureUI.t(this.qAW).getHeight();
    i = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.t(this.qAW).getLayoutParams()).bottomMargin + i;
    ScanTranslationCaptureUI.t(this.qAW).setTranslationY(i * f);
    int j = ScanTranslationCaptureUI.u(this.qAW).getHeight();
    int k = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.u(this.qAW).getLayoutParams()).bottomMargin;
    ScanTranslationCaptureUI.u(this.qAW).setTranslationY((k + (j + i)) * f);
    AppMethodBeat.o(81258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.4
 * JD-Core Version:    0.7.0.1
 */