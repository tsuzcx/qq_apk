package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;

final class ba$1
  implements Runnable
{
  ba$1(ba paramba) {}
  
  public final void run()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ba.a(this.piF).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    af.bDu();
    s.dT(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.1
 * JD-Core Version:    0.7.0.1
 */