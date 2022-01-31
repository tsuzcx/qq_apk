package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppInstallerUI$2
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$2(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28798);
    ab.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
    if (AppInstallerUI.b(this.yko) == 2) {
      i.at(this.yko, 3);
    }
    paramDialogInterface = c.Uc(AppInstallerUI.c(this.yko));
    ab.d("MicroMsg.AppInstallerUI", paramDialogInterface);
    if (paramDialogInterface != null)
    {
      j.a.ylQ.aE(1, true);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 72L, 1L, true);
      AppInstallerUI.a(this.yko, paramDialogInterface);
      AppMethodBeat.o(28798);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 73L, 1L, true);
    ab.e("MicroMsg.AppInstallerUI", "pack not found!");
    com.tencent.mm.ui.base.h.bO(this.yko, this.yko.getString(2131304425));
    i.drR();
    this.yko.finish();
    AppMethodBeat.o(28798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.2
 * JD-Core Version:    0.7.0.1
 */