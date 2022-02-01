package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.aa;

final class SnsUploadUI$25
  implements Runnable
{
  SnsUploadUI$25(SnsUploadUI paramSnsUploadUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(369924);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.REd.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    al.hgq();
    aa.lD(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(369924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.25
 * JD-Core Version:    0.7.0.1
 */