package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.y;

final class AppUpdaterUI$12
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$12(AppUpdaterUI paramAppUpdaterUI, c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppUpdaterUI", "click download button");
    AppUpdaterUI.a(this.ucg, 11);
    if (this.ucj != null) {
      this.ucj.deleteTempFile();
    }
    paramDialogInterface = AppUpdaterUI.e(this.ucg);
    paramDialogInterface.udr = true;
    paramDialogInterface.cqc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.12
 * JD-Core Version:    0.7.0.1
 */