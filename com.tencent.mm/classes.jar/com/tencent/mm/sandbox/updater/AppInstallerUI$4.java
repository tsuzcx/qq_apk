package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;

final class AppInstallerUI$4
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$4(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
    if ((AppInstallerUI.e(this.ubZ) != null) && (AppInstallerUI.e(this.ubZ).isShowing())) {
      AppInstallerUI.e(this.ubZ).dismiss();
    }
    j.a.udB.an(2, true);
    if (AppInstallerUI.b(this.ubZ) == 2) {
      i.af(this.ubZ, 4);
    }
    h.nFQ.a(405L, 74L, 1L, true);
    i.cpW();
    AppInstallerUI.d(this.ubZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.4
 * JD-Core Version:    0.7.0.1
 */