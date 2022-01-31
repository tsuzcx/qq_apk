package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayKeyboard$5
  implements Animator.AnimatorListener
{
  WcPayKeyboard$5(WcPayKeyboard paramWcPayKeyboard, int paramInt, boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(155647);
    WcPayKeyboard.d(this.AVV).setVisibility(4);
    WcPayKeyboard.d(this.AVV).setTranslationY(WcPayKeyboard.d(this.AVV).getTranslationY() - this.AVW);
    if (this.AVX) {
      this.AVV.setVisibility(8);
    }
    AppMethodBeat.o(155647);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.5
 * JD-Core Version:    0.7.0.1
 */