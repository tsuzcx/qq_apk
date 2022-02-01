package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtPlanAddUI$18
  implements Animator.AnimatorListener
{
  WalletLqtPlanAddUI$18(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(68852);
    if (this.CCy.booleanValue())
    {
      WalletLqtPlanAddUI.r(this.CCt).setVisibility(8);
      AppMethodBeat.o(68852);
      return;
    }
    WalletLqtPlanAddUI.r(this.CCt).setVisibility(0);
    AppMethodBeat.o(68852);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.18
 * JD-Core Version:    0.7.0.1
 */