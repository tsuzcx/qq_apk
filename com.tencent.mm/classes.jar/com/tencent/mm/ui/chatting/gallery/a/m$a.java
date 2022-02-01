package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "listener", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$1"})
final class m$a
  implements ValueAnimator.AnimatorUpdateListener
{
  m$a(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(188339);
    View localView = this.tiK;
    p.g(paramValueAnimator, "listener");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(188339);
      throw paramValueAnimator;
    }
    localView.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(188339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.m.a
 * JD-Core Version:    0.7.0.1
 */