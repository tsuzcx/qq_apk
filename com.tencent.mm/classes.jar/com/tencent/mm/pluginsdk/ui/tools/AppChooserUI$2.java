package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class AppChooserUI$2
  implements DialogInterface.OnClickListener
{
  AppChooserUI$2(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125855);
    if ((AppChooserUI.c(this.wdL) != null) && (AppChooserUI.c(this.wdL).wdP != null))
    {
      g.RL().Ru().set(AppChooserUI.a(this.wdL, 274528), AppChooserUI.c(this.wdL).wdP.activityInfo.packageName);
      AppChooserUI.a(this.wdL, AppChooserUI.c(this.wdL).wdP.activityInfo.packageName, true);
    }
    AppMethodBeat.o(125855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.2
 * JD-Core Version:    0.7.0.1
 */