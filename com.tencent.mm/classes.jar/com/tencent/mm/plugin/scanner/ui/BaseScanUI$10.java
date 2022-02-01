package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$10
  implements Animator.AnimatorListener
{
  BaseScanUI$10(BaseScanUI paramBaseScanUI, Animator.AnimatorListener paramAnimatorListener, View paramView, boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(195393);
    if (this.vRz != null) {
      this.vRz.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(195393);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(195392);
    View localView = this.val$view;
    if (this.rPZ) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.vRz != null) {
        this.vRz.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(195392);
      return;
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(195394);
    if (this.vRz != null) {
      this.vRz.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(195394);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(195391);
    if (this.vRz != null) {
      this.vRz.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(195391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.10
 * JD-Core Version:    0.7.0.1
 */