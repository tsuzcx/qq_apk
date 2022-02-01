package com.tencent.mm.plugin.profile.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SayHiWithSnsPermissionUI3$7
  implements ValueAnimator.AnimatorUpdateListener
{
  SayHiWithSnsPermissionUI3$7(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3, TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(224265);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.Hdg.setTextColor(i);
    AppMethodBeat.o(224265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.7
 * JD-Core Version:    0.7.0.1
 */