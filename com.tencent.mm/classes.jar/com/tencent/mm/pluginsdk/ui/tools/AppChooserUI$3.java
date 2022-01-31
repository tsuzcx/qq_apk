package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

final class AppChooserUI$3
  implements DialogInterface.OnClickListener
{
  AppChooserUI$3(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((AppChooserUI.c(this.slj) != null) && (AppChooserUI.c(this.slj).sln != null)) {
      AppChooserUI.a(this.slj, AppChooserUI.c(this.slj).sln.activityInfo.packageName, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.3
 * JD-Core Version:    0.7.0.1
 */