package com.tencent.mm.plugin.profile.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SayHiWithSnsPermissionUI3$6
  implements ValueAnimator.AnimatorUpdateListener
{
  SayHiWithSnsPermissionUI3$6(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(272060);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(272060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.6
 * JD-Core Version:    0.7.0.1
 */