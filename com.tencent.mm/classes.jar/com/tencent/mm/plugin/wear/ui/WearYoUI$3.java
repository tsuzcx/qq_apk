package com.tencent.mm.plugin.wear.ui;

import android.os.Vibrator;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

final class WearYoUI$3
  implements Runnable
{
  WearYoUI$3(WearYoUI paramWearYoUI) {}
  
  public final void run()
  {
    WearYoUI.c(this.qTa).vibrate(200L);
    WearYoUI.d(this.qTa).animate().scaleX(1.2F);
    WearYoUI.d(this.qTa).animate().scaleY(1.2F);
    WearYoUI.d(this.qTa).animate().setDuration(200L);
    WearYoUI.d(this.qTa).animate().start();
    WearYoUI.d(this.qTa).animate().setListener(new WearYoUI.a(this.qTa, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.3
 * JD-Core Version:    0.7.0.1
 */