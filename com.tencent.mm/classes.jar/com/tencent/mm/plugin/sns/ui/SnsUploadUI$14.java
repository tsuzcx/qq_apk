package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;

final class SnsUploadUI$14
  implements Runnable
{
  SnsUploadUI$14(SnsUploadUI paramSnsUploadUI) {}
  
  public final void run()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.pjp.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    af.bDu();
    s.dT(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.14
 * JD-Core Version:    0.7.0.1
 */