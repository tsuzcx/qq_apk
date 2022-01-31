package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMSightRecordButton$1$1
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$1$1(MMSightRecordButton.1 param1) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55090);
    ab.b("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
    if (this.oOh.oOf != null) {
      this.oOh.oOf.boZ();
    }
    AppMethodBeat.o(55090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1.1
 * JD-Core Version:    0.7.0.1
 */