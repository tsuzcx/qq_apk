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
    AppMethodBeat.i(189456);
    if (this.yGm != null) {
      this.yGm.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(189456);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(51692);
    View localView = this.val$view;
    if (this.ufX) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.yGm != null) {
        this.yGm.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(51692);
      return;
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(189457);
    if (this.yGm != null) {
      this.yGm.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(189457);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(189455);
    if (this.yGm != null) {
      this.yGm.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(189455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.11
 * JD-Core Version:    0.7.0.1
 */