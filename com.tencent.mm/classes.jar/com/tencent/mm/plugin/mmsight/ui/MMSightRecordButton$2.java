package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSightRecordButton$2
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$2(MMSightRecordButton paramMMSightRecordButton) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55093);
    MMSightRecordButton.a(this.oOg, false);
    if (this.oOi != null) {
      this.oOi.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(55093);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(55092);
    MMSightRecordButton.a(this.oOg, true);
    if (this.oOi != null) {
      this.oOi.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(55092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.2
 * JD-Core Version:    0.7.0.1
 */