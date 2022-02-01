package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
public final class ScanCodeMaskView$n
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(170055);
    ScanCodeMaskView.l(this.yNL);
    AppMethodBeat.o(170055);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.n
 * JD-Core Version:    0.7.0.1
 */