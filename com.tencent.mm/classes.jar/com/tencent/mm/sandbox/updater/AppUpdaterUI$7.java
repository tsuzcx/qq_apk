package com.tencent.mm.sandbox.updater;

import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

final class AppUpdaterUI$7
  implements Runnable
{
  AppUpdaterUI$7(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void run()
  {
    h.a(this.ucg, AppUpdaterUI.e(this.ucg).desc, this.ucg.getString(R.l.app_tip), new AppUpdaterUI.7.1(this)).setOnCancelListener(new AppUpdaterUI.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.7
 * JD-Core Version:    0.7.0.1
 */