package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$16
  extends AnimatorListenerAdapter
{
  SightCaptureUI$16(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55207);
    SightCaptureUI.H(this.oQf).setEnabled(true);
    AppMethodBeat.o(55207);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(55208);
    SightCaptureUI.H(this.oQf).setEnabled(false);
    AppMethodBeat.o(55208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.16
 * JD-Core Version:    0.7.0.1
 */