package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class AppUpdaterUI$6
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$6(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((AppUpdaterUI.b(this.ucg) != null) && (!AppUpdaterUI.b(this.ucg).isShowing())) {
      AppUpdaterUI.b(this.ucg).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.6
 * JD-Core Version:    0.7.0.1
 */