package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUITest$11
  extends AnimatorListenerAdapter
{
  SightCaptureUITest$11(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(150462);
    SightCaptureUITest.z(this.oQq).setEnabled(true);
    AppMethodBeat.o(150462);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(150463);
    SightCaptureUITest.z(this.oQq).setEnabled(false);
    AppMethodBeat.o(150463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.11
 * JD-Core Version:    0.7.0.1
 */