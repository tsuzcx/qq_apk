package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtPlanAddUI$20
  implements Animator.AnimatorListener
{
  WalletLqtPlanAddUI$20(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(316382);
    if (this.Vgl.booleanValue())
    {
      WalletLqtPlanAddUI.v(this.Vge).setVisibility(8);
      AppMethodBeat.o(316382);
      return;
    }
    WalletLqtPlanAddUI.v(this.Vge).setVisibility(0);
    AppMethodBeat.o(316382);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.20
 * JD-Core Version:    0.7.0.1
 */