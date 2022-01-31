package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUITest$7
  extends AnimatorListenerAdapter
{
  SightCaptureUITest$7(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(150453);
    SightCaptureUITest.A(this.oQq).setVisibility(8);
    AppMethodBeat.o(150453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.7
 * JD-Core Version:    0.7.0.1
 */