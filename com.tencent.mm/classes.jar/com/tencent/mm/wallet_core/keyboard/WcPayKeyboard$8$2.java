package com.tencent.mm.wallet_core.keyboard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayKeyboard$8$2
  implements ValueAnimator.AnimatorUpdateListener
{
  WcPayKeyboard$8$2(WcPayKeyboard.8 param8, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(155652);
    if (WcPayKeyboard.e(this.AVZ.AVV) != null)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      float f2 = this.AVW - f1;
      ab.d("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(this.AVW), Float.valueOf(f1), Float.valueOf(f2) });
      WcPayKeyboard.e(this.AVZ.AVV).aV(f2);
    }
    AppMethodBeat.o(155652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.8.2
 * JD-Core Version:    0.7.0.1
 */