package com.tencent.mm.plugin.profile.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SayHiWithSnsPermissionUI2$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SayHiWithSnsPermissionUI2$4(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(279661);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(279661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.4
 * JD-Core Version:    0.7.0.1
 */