package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$2"})
final class ScanCodeMaskView$l
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanCodeMaskView$l(ScanCodeMaskView paramScanCodeMaskView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52387);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(52387);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    ScanCodeMaskView.g(this.yNL).setAlpha(1.0F - f);
    paramValueAnimator = ScanCodeMaskView.h(this.yNL);
    if (paramValueAnimator != null) {
      paramValueAnimator.setAlpha(1.0F - f);
    }
    paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.yNL);
    int i = 0;
    paramValueAnimator = paramValueAnimator.iterator();
    while (paramValueAnimator.hasNext())
    {
      Object localObject = paramValueAnimator.next();
      if (i < 0) {
        j.gkd();
      }
      localObject = (View)localObject;
      if (i < ScanCodeMaskView.i(this.yNL))
      {
        ((View)localObject).setAlpha(f);
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
      }
      i += 1;
    }
    if (ScanCodeMaskView.j(this.yNL)) {
      ScanCodeMaskView.k(this.yNL).setAlpha(f);
    }
    AppMethodBeat.o(52387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.l
 * JD-Core Version:    0.7.0.1
 */