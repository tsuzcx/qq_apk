package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToNext$1$1"})
final class WhatsNewView$e
  implements ValueAnimator.AnimatorUpdateListener
{
  WhatsNewView$e(WhatsNewView paramWhatsNewView, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(230996);
    p.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(230996);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    WhatsNewView.d(this.JPu).y(this.JPw, f);
    AppMethodBeat.o(230996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.e
 * JD-Core Version:    0.7.0.1
 */