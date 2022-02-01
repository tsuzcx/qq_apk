package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class ScanTranslationResultUI$i
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationResultUI$i(ScanTranslationResultUI paramScanTranslationResultUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(162357);
    p.j(paramValueAnimator, "valueAnimator");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(162357);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (f <= 0.1F) {
      ScanTranslationResultUI.k(this.ISE).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ScanTranslationResultUI.k(this.ISE).setTranslationY(f * (ScanTranslationResultUI.l(this.ISE) - ScanTranslationResultUI.k(this.ISE).getHeight()));
      AppMethodBeat.o(162357);
      return;
      if (f >= 0.9F) {
        ScanTranslationResultUI.k(this.ISE).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.i
 * JD-Core Version:    0.7.0.1
 */