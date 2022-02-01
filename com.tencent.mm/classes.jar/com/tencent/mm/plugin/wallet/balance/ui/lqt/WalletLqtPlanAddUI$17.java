package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtPlanAddUI$17
  implements Animator.AnimatorListener
{
  WalletLqtPlanAddUI$17(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(68851);
    if (!this.CCy.booleanValue()) {
      WalletLqtPlanAddUI.x(this.CCt).setVisibility(8);
    }
    AppMethodBeat.o(68851);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.17
 * JD-Core Version:    0.7.0.1
 */