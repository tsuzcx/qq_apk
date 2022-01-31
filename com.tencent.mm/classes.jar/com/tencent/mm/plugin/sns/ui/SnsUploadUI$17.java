package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;

final class SnsUploadUI$17
  implements Runnable
{
  SnsUploadUI$17(SnsUploadUI paramSnsUploadUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39753);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.sbR.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    ag.coU();
    s.fF(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(39753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.17
 * JD-Core Version:    0.7.0.1
 */