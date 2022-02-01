package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "listener", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$1"})
final class m$a
  implements ValueAnimator.AnimatorUpdateListener
{
  m$a(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(231292);
    View localView = this.tBN;
    p.g(paramValueAnimator, "listener");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(231292);
      throw paramValueAnimator;
    }
    localView.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(231292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.m.a
 * JD-Core Version:    0.7.0.1
 */