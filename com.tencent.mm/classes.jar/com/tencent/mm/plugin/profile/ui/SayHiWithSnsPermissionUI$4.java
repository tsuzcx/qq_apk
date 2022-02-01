package com.tencent.mm.plugin.profile.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SayHiWithSnsPermissionUI$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SayHiWithSnsPermissionUI$4(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(209831);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(209831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.4
 * JD-Core Version:    0.7.0.1
 */