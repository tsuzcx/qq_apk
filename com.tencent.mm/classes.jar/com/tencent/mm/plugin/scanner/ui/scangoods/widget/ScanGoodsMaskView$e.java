package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class ScanGoodsMaskView$e
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanGoodsMaskView$e(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52290);
    if (paramValueAnimator == null)
    {
      AppMethodBeat.o(52290);
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(52290);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    ScanGoodsMaskView.d(this.ywB).setAlpha(0.5F - f * 0.5F);
    if (this.ywE)
    {
      ScanGoodsMaskView.e(this.ywB).setAlpha(1.0F - f);
      ScanGoodsMaskView.f(this.ywB).setAlpha(1.0F - f);
    }
    if (ScanGoodsMaskView.g(this.ywB)) {
      ScanGoodsMaskView.c(this.ywB).setAlpha(f);
    }
    ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(ScanGoodsMaskView.d(this.ywB).getAlpha()), Float.valueOf(f) });
    AppMethodBeat.o(52290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.e
 * JD-Core Version:    0.7.0.1
 */