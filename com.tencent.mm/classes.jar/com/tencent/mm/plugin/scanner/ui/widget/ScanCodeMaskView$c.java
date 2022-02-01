package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanCodeMaskView$c
  implements Animator.AnimatorListener
{
  ScanCodeMaskView$c(Animator.AnimatorListener paramAnimatorListener, ScanCodeMaskView paramScanCodeMaskView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(52383);
    this.PfG.dSg();
    Animator.AnimatorListener localAnimatorListener = this.PdD;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(52383);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(52382);
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
    this.PfG.dSg();
    Animator.AnimatorListener localAnimatorListener = this.PdD;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(52382);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(52381);
    Animator.AnimatorListener localAnimatorListener = this.PdD;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(52381);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(52384);
    Animator.AnimatorListener localAnimatorListener = this.PdD;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(52384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.c
 * JD-Core Version:    0.7.0.1
 */