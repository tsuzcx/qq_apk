package com.tencent.mm.ui.widget.pulldown;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class AppLayoutPullDownBehavior$b
  implements ValueAnimator.AnimatorUpdateListener
{
  AppLayoutPullDownBehavior$b(AppLayoutPullDownBehavior paramAppLayoutPullDownBehavior, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(250001);
    p.j(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(250001);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    AppLayoutPullDownBehavior.K(this.AKP, i);
    AppMethodBeat.o(250001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.AppLayoutPullDownBehavior.b
 * JD-Core Version:    0.7.0.1
 */