package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$11
  implements Animator.AnimatorListener
{
  BaseScanUI$11(BaseScanUI paramBaseScanUI, Animator.AnimatorListener paramAnimatorListener, View paramView, boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(186174);
    if (this.yqm != null) {
      this.yqm.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(186174);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(51692);
    View localView = this.val$view;
    if (this.tVb) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.yqm != null) {
        this.yqm.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(51692);
      return;
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(186175);
    if (this.yqm != null) {
      this.yqm.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(186175);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(186173);
    if (this.yqm != null) {
      this.yqm.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(186173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.11
 * JD-Core Version:    0.7.0.1
 */