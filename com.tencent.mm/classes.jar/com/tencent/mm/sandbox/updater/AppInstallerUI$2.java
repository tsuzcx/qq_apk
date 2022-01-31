package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.y;

final class AppInstallerUI$2
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$2(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
    if (AppInstallerUI.b(this.ubZ) == 2) {
      i.af(this.ubZ, 3);
    }
    paramDialogInterface = c.Iq(AppInstallerUI.c(this.ubZ));
    y.d("MicroMsg.AppInstallerUI", paramDialogInterface);
    if (paramDialogInterface != null)
    {
      j.a.udB.an(1, true);
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 72L, 1L, true);
      AppInstallerUI.a(this.ubZ, paramDialogInterface);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 73L, 1L, true);
    y.e("MicroMsg.AppInstallerUI", "pack not found!");
    com.tencent.mm.ui.base.h.bC(this.ubZ, this.ubZ.getString(R.l.update_err_pack_not_found));
    i.cqb();
    this.ubZ.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.2
 * JD-Core Version:    0.7.0.1
 */