package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class MMSightRecordButton$1$1
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$1$1(MMSightRecordButton.1 param1) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.l("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
    if (this.moV.moT != null) {
      this.moV.moT.aKR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1.1
 * JD-Core Version:    0.7.0.1
 */