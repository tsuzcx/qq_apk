package com.tencent.mm.plugin.mv.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$updateViewHeight$1$2"})
final class MusicMVCardChooseView$y
  implements ValueAnimator.AnimatorUpdateListener
{
  MusicMVCardChooseView$y(View paramView, boolean paramBoolean, int paramInt1, b paramb, a parama, int paramInt2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(237982);
    p.j(paramValueAnimator, "valueAnimator");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(237982);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = this.Gof;
    ViewGroup.LayoutParams localLayoutParams = this.Gof.getLayoutParams();
    localLayoutParams.height = i;
    paramValueAnimator.setLayoutParams(localLayoutParams);
    paramValueAnimator = this.Goi;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.invoke(Float.valueOf((i - this.Gok) / (this.Goh - this.Gok)));
      AppMethodBeat.o(237982);
      return;
    }
    AppMethodBeat.o(237982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.y
 * JD-Core Version:    0.7.0.1
 */