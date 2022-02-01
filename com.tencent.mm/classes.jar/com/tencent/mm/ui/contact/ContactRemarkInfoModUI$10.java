package com.tencent.mm.ui.contact;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactRemarkInfoModUI$10
  implements ValueAnimator.AnimatorUpdateListener
{
  ContactRemarkInfoModUI$10(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(281522);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(281522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.10
 * JD-Core Version:    0.7.0.1
 */