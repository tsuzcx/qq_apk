package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppChooserUI$3
  implements DialogInterface.OnClickListener
{
  AppChooserUI$3(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125856);
    if ((AppChooserUI.c(this.wdL) != null) && (AppChooserUI.c(this.wdL).wdP != null)) {
      AppChooserUI.a(this.wdL, AppChooserUI.c(this.wdL).wdP.activityInfo.packageName, false);
    }
    AppMethodBeat.o(125856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.3
 * JD-Core Version:    0.7.0.1
 */