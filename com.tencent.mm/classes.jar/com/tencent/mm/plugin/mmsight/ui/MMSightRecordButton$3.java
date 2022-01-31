package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSightRecordButton$3
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$3(MMSightRecordButton paramMMSightRecordButton, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55095);
    MMSightRecordButton.a(this.oOg, false);
    if (this.oOi != null) {
      this.oOi.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(55095);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(55094);
    MMSightRecordButton.a(this.oOg, true);
    if (this.oOi != null) {
      this.oOi.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(55094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.3
 * JD-Core Version:    0.7.0.1
 */