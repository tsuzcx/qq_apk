package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScannerFlashSwitcher$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScannerFlashSwitcher$1(ScannerFlashSwitcher paramScannerFlashSwitcher) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(81319);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ScannerFlashSwitcher.a(this.qBe).setAlpha(f);
    AppMethodBeat.o(81319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.1
 * JD-Core Version:    0.7.0.1
 */