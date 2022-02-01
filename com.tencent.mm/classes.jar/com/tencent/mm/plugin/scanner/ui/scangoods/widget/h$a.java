package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateCustomSuccessView$1$1"})
final class h$a
  implements ValueAnimator.AnimatorUpdateListener
{
  h$a(View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(186348);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(186348);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    this.yvT.setRotation(360.0F - Math.abs(f));
    AppMethodBeat.o(186348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h.a
 * JD-Core Version:    0.7.0.1
 */