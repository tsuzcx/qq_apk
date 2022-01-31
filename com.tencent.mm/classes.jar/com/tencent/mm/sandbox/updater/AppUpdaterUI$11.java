package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

final class AppUpdaterUI$11
  implements Runnable
{
  AppUpdaterUI$11(AppUpdaterUI paramAppUpdaterUI, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = bk.ZF(this.uca);
    this.ucg.startActivity(localIntent);
    AppUpdaterUI.f(this.ucg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.11
 * JD-Core Version:    0.7.0.1
 */