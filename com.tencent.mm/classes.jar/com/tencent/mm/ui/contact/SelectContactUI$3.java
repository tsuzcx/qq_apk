package com.tencent.mm.ui.contact;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SelectContactUI$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SelectContactUI$3(SelectContactUI paramSelectContactUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252741);
    Log.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(252741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */