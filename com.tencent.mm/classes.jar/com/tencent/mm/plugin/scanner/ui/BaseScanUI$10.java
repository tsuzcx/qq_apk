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
    AppMethodBeat.i(199503);
    if (this.xck != null) {
      this.xck.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(199503);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(199502);
    View localView = this.val$view;
    if (this.sXQ) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.xck != null) {
        this.xck.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(199502);
      return;
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(199504);
    if (this.xck != null) {
      this.xck.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(199504);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(199501);
    if (this.xck != null) {
      this.xck.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(199501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.10
 * JD-Core Version:    0.7.0.1
 */