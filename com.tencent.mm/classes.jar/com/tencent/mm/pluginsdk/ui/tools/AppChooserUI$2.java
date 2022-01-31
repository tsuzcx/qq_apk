package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class AppChooserUI$2
  implements DialogInterface.OnClickListener
{
  AppChooserUI$2(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((AppChooserUI.c(this.slj) != null) && (AppChooserUI.c(this.slj).sln != null))
    {
      g.DP().Dz().o(AppChooserUI.a(this.slj, 274528), AppChooserUI.c(this.slj).sln.activityInfo.packageName);
      AppChooserUI.a(this.slj, AppChooserUI.c(this.slj).sln.activityInfo.packageName, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.2
 * JD-Core Version:    0.7.0.1
 */