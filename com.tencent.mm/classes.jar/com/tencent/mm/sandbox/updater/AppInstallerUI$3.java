package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

final class AppInstallerUI$3
  implements Runnable
{
  AppInstallerUI$3(AppInstallerUI paramAppInstallerUI, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = bk.ZF(this.uca);
    this.ubZ.startActivity(localIntent);
    AppInstallerUI.d(this.ubZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.3
 * JD-Core Version:    0.7.0.1
 */