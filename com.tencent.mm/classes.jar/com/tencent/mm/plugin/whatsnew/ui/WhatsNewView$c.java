package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToFinish$1$1"})
final class WhatsNewView$c
  implements ValueAnimator.AnimatorUpdateListener
{
  WhatsNewView$c(WhatsNewView paramWhatsNewView, float paramFloat) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(230991);
    p.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(230991);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    WhatsNewView.e(this.JPu).setTranslationX(-WhatsNewView.e(this.JPu).getWidth() * f);
    WhatsNewView.f(this.JPu).setAlpha(1.0F - f);
    AppMethodBeat.o(230991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.c
 * JD-Core Version:    0.7.0.1
 */