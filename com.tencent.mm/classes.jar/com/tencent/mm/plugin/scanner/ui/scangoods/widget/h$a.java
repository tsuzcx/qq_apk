package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateCustomSuccessView$1$1"})
final class h$a
  implements ValueAnimator.AnimatorUpdateListener
{
  h$a(View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(240591);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(240591);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    this.CPL.setRotation(360.0F - Math.abs(f));
    AppMethodBeat.o(240591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h.a
 * JD-Core Version:    0.7.0.1
 */