package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
public final class ScanCodeMaskView$f
  implements Animator.AnimatorListener
{
  ScanCodeMaskView$f(Animator.AnimatorListener paramAnimatorListener) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(52383);
    this.xjJ.cqU();
    Animator.AnimatorListener localAnimatorListener = this.xjL;
    if (localAnimatorListener != null)
    {
      localAnimatorListener.onAnimationCancel(paramAnimator);
      AppMethodBeat.o(52383);
      return;
    }
    AppMethodBeat.o(52383);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(52382);
    ac.i("MicroMsg.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
    this.xjJ.cqU();
    Animator.AnimatorListener localAnimatorListener = this.xjL;
    if (localAnimatorListener != null)
    {
      localAnimatorListener.onAnimationEnd(paramAnimator);
      AppMethodBeat.o(52382);
      return;
    }
    AppMethodBeat.o(52382);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(52381);
    Animator.AnimatorListener localAnimatorListener = this.xjL;
    if (localAnimatorListener != null)
    {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
      AppMethodBeat.o(52381);
      return;
    }
    AppMethodBeat.o(52381);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(52384);
    Animator.AnimatorListener localAnimatorListener = this.xjL;
    if (localAnimatorListener != null)
    {
      localAnimatorListener.onAnimationStart(paramAnimator);
      AppMethodBeat.o(52384);
      return;
    }
    AppMethodBeat.o(52384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.f
 * JD-Core Version:    0.7.0.1
 */