package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class ScanGoodsMaskView$c
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanGoodsMaskView$c(ScanGoodsMaskView paramScanGoodsMaskView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(186357);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(186357);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    ScanGoodsMaskView.a(this.ywB).setRotation(360.0F - Math.abs(15.0F + -15.0F * f));
    ScanGoodsMaskView.a(this.ywB).setAlpha(f);
    ScanGoodsMaskView.c(this.ywB).setAlpha(1.0F - f);
    AppMethodBeat.o(186357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.c
 * JD-Core Version:    0.7.0.1
 */