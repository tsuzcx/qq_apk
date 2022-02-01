package com.tencent.mm.plugin.profile.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SayHiWithSnsPermissionUI3$9
  implements ValueAnimator.AnimatorUpdateListener
{
  SayHiWithSnsPermissionUI3$9(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3, TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(305562);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.Nbt.setTextColor(i);
    AppMethodBeat.o(305562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.9
 * JD-Core Version:    0.7.0.1
 */