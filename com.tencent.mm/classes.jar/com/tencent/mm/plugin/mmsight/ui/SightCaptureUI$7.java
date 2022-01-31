package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$7
  extends AnimatorListenerAdapter
{
  SightCaptureUI$7(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55191);
    SightCaptureUI.I(this.oQf).setVisibility(8);
    AppMethodBeat.o(55191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.7
 * JD-Core Version:    0.7.0.1
 */