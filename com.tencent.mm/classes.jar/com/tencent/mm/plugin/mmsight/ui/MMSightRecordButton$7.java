package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class MMSightRecordButton$7
  extends AnimatorListenerAdapter
{
  MMSightRecordButton$7(MMSightRecordButton paramMMSightRecordButton, long paramLong) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((MMSightRecordButton.g(this.moU) > 0L) && (this.moX <= 500L))
    {
      y.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.a(this.moU)), Boolean.valueOf(MMSightRecordButton.b(this.moU)) });
      MMSightRecordButton.h(this.moU);
      if ((!MMSightRecordButton.b(this.moU)) && (MMSightRecordButton.i(this.moU) != null)) {
        MMSightRecordButton.i(this.moU).aKS();
      }
    }
    do
    {
      do
      {
        return;
        if (!MMSightRecordButton.b(this.moU)) {
          break;
        }
        y.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
      } while (MMSightRecordButton.d(this.moU) == null);
      MMSightRecordButton.d(this.moU).aKO();
      return;
      y.i("MicroMsg.MMSightRecordButton", "error action up");
    } while (MMSightRecordButton.j(this.moU) == null);
    MMSightRecordButton.j(this.moU).bkb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.7
 * JD-Core Version:    0.7.0.1
 */