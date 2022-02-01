package com.tencent.mm.plugin.remittance.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class RemittanceRemarkInputHalfPage$c
  implements ValueAnimator.AnimatorUpdateListener
{
  RemittanceRemarkInputHalfPage$c(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(203497);
    View localView = this.IuU.oFW;
    p.j(paramValueAnimator, "anim");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(203497);
      throw paramValueAnimator;
    }
    localView.setPadding(0, 0, 0, ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(203497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage.c
 * JD-Core Version:    0.7.0.1
 */