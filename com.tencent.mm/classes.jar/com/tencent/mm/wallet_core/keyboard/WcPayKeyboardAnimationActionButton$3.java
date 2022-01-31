package com.tencent.mm.wallet_core.keyboard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayKeyboardAnimationActionButton$3
  implements ValueAnimator.AnimatorUpdateListener
{
  WcPayKeyboardAnimationActionButton$3(WcPayKeyboardAnimationActionButton paramWcPayKeyboardAnimationActionButton) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(142635);
    WcPayKeyboardAnimationActionButton.a(this.AWB, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    ab.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.b(this.AWB)) });
    this.AWB.invalidate();
    AppMethodBeat.o(142635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.3
 * JD-Core Version:    0.7.0.1
 */