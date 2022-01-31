package com.tencent.mm.wallet_core.keyboard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayKeyboard$6
  implements ValueAnimator.AnimatorUpdateListener
{
  WcPayKeyboard$6(WcPayKeyboard paramWcPayKeyboard, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(155648);
    if (WcPayKeyboard.e(this.AVV) != null)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      float f2 = this.AVW - f1;
      ab.d("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(this.AVW), Float.valueOf(f1), Float.valueOf(f2) });
      WcPayKeyboard.e(this.AVV).aV(f2);
    }
    AppMethodBeat.o(155648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.6
 * JD-Core Version:    0.7.0.1
 */