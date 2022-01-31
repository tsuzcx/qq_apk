package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;

final class SnsUIAction$1
  implements Runnable
{
  SnsUIAction$1(SnsUIAction paramSnsUIAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(39637);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    SnsUIAction.a(this.sbh).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    ag.coU();
    s.fF(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(39637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.1
 * JD-Core Version:    0.7.0.1
 */