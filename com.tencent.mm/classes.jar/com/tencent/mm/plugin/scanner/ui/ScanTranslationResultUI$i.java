package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class ScanTranslationResultUI$i
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationResultUI$i(ScanTranslationResultUI paramScanTranslationResultUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(162357);
    k.g(paramValueAnimator, "valueAnimator");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(162357);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (f <= 0.1F) {
      ScanTranslationResultUI.k(this.vUE).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ScanTranslationResultUI.k(this.vUE).setTranslationY(f * (ScanTranslationResultUI.l(this.vUE) - ScanTranslationResultUI.k(this.vUE).getHeight()));
      AppMethodBeat.o(162357);
      return;
      if (f >= 0.9F) {
        ScanTranslationResultUI.k(this.vUE).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.i
 * JD-Core Version:    0.7.0.1
 */