package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class AppUpdaterUI$13
  implements DialogInterface.OnCancelListener
{
  AppUpdaterUI$13(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.AppUpdaterUI", "click cancel button");
    AppUpdaterUI.a(this.ucg, 12);
    AppUpdaterUI.i(this.ucg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.13
 * JD-Core Version:    0.7.0.1
 */