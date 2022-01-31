package com.tencent.mm.plugin.wear.ui;

import android.os.Vibrator;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WearYoUI$3
  implements Runnable
{
  WearYoUI$3(WearYoUI paramWearYoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(26465);
    WearYoUI.c(this.uIh).vibrate(200L);
    WearYoUI.d(this.uIh).animate().scaleX(1.2F);
    WearYoUI.d(this.uIh).animate().scaleY(1.2F);
    WearYoUI.d(this.uIh).animate().setDuration(200L);
    WearYoUI.d(this.uIh).animate().start();
    WearYoUI.d(this.uIh).animate().setListener(new WearYoUI.a(this.uIh, 1));
    AppMethodBeat.o(26465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.3
 * JD-Core Version:    0.7.0.1
 */