package com.tencent.mm.wallet_core.keyboard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayKeyboardAnimationActionButton$4
  implements ValueAnimator.AnimatorUpdateListener
{
  WcPayKeyboardAnimationActionButton$4(WcPayKeyboardAnimationActionButton paramWcPayKeyboardAnimationActionButton) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(142636);
    WcPayKeyboardAnimationActionButton.b(this.AWB, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    ab.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.c(this.AWB)) });
    this.AWB.invalidate();
    AppMethodBeat.o(142636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.4
 * JD-Core Version:    0.7.0.1
 */