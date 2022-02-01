package com.tencent.mm.plugin.scanner.box;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$1"})
final class BoxDialogView$e
  implements ValueAnimator.AnimatorUpdateListener
{
  BoxDialogView$e(BoxDialogView paramBoxDialogView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52086);
    BoxDialogView localBoxDialogView = this.yAL;
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(52086);
      throw paramValueAnimator;
    }
    BoxDialogView.b(localBoxDialogView, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(52086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.e
 * JD-Core Version:    0.7.0.1
 */