package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class ScanCodeMaskView$e
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanCodeMaskView$e(ScanCodeMaskView paramScanCodeMaskView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52380);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(52380);
      throw paramValueAnimator;
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    ScanCodeMaskView.a(this.CRD).setTranslationY(f2);
    float f1 = ScanCodeMaskView.b(this.CRD).height() * ScanCodeMaskView.c(this.CRD);
    f2 -= ScanCodeMaskView.b(this.CRD).top;
    if (f2 <= f1)
    {
      f1 = (f1 - f2) / f1;
      ScanCodeMaskView.a(this.CRD).setAlpha(1.0F - f1);
      AppMethodBeat.o(52380);
      return;
    }
    if (f2 >= ScanCodeMaskView.b(this.CRD).height() * (1.0F - ScanCodeMaskView.c(this.CRD)))
    {
      f1 = (f2 - ScanCodeMaskView.b(this.CRD).height() * (1.0F - ScanCodeMaskView.c(this.CRD))) / f1;
      ScanCodeMaskView.a(this.CRD).setAlpha(1.0F - f1);
      AppMethodBeat.o(52380);
      return;
    }
    ScanCodeMaskView.a(this.CRD).setAlpha(1.0F);
    AppMethodBeat.o(52380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.e
 * JD-Core Version:    0.7.0.1
 */