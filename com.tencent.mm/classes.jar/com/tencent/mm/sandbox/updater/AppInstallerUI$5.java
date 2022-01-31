package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.c;

final class AppInstallerUI$5
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$5(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.a(405L, 75L, 1L, true);
    if ((AppInstallerUI.e(this.ubZ) != null) && (!AppInstallerUI.e(this.ubZ).isShowing())) {
      AppInstallerUI.e(this.ubZ).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.5
 * JD-Core Version:    0.7.0.1
 */