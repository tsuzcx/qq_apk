package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/box/BoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
public final class BoxDialogView$m
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(161053);
    BoxDialogView.a(this.yAL);
    AppMethodBeat.o(161053);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(52095);
    BoxDialogView.b(this.yAL);
    BoxDialogView.a(this.yAL);
    ae.v("MicroMsg.BoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(BoxDialogView.d(this.yAL).getTranslationY()) });
    AppMethodBeat.o(52095);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.m
 * JD-Core Version:    0.7.0.1
 */