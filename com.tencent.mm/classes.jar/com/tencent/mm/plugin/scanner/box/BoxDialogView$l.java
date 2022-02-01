package com.tencent.mm.plugin.scanner.box;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class BoxDialogView$l
  implements ValueAnimator.AnimatorUpdateListener
{
  BoxDialogView$l(BoxDialogView paramBoxDialogView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(52094);
    BoxDialogView.c(this.yAL, BoxDialogView.d(this.yAL).getTranslationY());
    BoxDialogView.a(this.yAL, BoxDialogView.d(this.yAL).getTranslationY());
    AppMethodBeat.o(52094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.l
 * JD-Core Version:    0.7.0.1
 */