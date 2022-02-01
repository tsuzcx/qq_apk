package com.tencent.mm.plugin.scanner.box;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
public final class BoxDialogView$h
  implements ValueAnimator.AnimatorUpdateListener
{
  BoxDialogView$h(float paramFloat1, float paramFloat2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52090);
    BoxDialogView.a(this.yAL, BoxDialogView.d(this.yAL).getTranslationY());
    if (paramValueAnimator == null)
    {
      AppMethodBeat.o(52090);
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(52090);
      throw paramValueAnimator;
    }
    float f1 = ((Float)paramValueAnimator).floatValue();
    float f2 = this.yAS;
    float f3 = this.yAT;
    float f4 = this.yAS;
    BoxDialogView.b(this.yAL, f1 * (f3 - f4) + f2);
    AppMethodBeat.o(52090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.h
 * JD-Core Version:    0.7.0.1
 */