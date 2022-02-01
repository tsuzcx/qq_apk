package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$2$1"})
final class ScanCodeMaskView$g
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanCodeMaskView$g(ScanCodeMaskView paramScanCodeMaskView, float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(170047);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(170047);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.CRD);
    int i = 0;
    paramValueAnimator = paramValueAnimator.iterator();
    while (paramValueAnimator.hasNext())
    {
      Object localObject = paramValueAnimator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject = (View)localObject;
      if (i < ScanCodeMaskView.i(this.CRD))
      {
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
      }
      i += 1;
    }
    AppMethodBeat.o(170047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.g
 * JD-Core Version:    0.7.0.1
 */