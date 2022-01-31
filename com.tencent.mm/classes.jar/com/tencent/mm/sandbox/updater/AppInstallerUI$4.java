package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;

final class AppInstallerUI$4
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$4(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28800);
    ab.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
    if ((AppInstallerUI.e(this.yko) != null) && (AppInstallerUI.e(this.yko).isShowing())) {
      AppInstallerUI.e(this.yko).dismiss();
    }
    j.a.ylQ.aE(2, true);
    if (AppInstallerUI.b(this.yko) == 2) {
      i.at(this.yko, 4);
    }
    h.qsU.idkeyStat(405L, 74L, 1L, true);
    i.drM();
    AppInstallerUI.d(this.yko);
    AppMethodBeat.o(28800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.4
 * JD-Core Version:    0.7.0.1
 */