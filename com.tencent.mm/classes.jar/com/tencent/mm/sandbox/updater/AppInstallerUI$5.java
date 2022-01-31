package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.b.c;

final class AppInstallerUI$5
  implements DialogInterface.OnClickListener
{
  AppInstallerUI$5(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28801);
    h.qsU.idkeyStat(405L, 75L, 1L, true);
    if ((AppInstallerUI.e(this.yko) != null) && (!AppInstallerUI.e(this.yko).isShowing())) {
      AppInstallerUI.e(this.yko).show();
    }
    AppMethodBeat.o(28801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.5
 * JD-Core Version:    0.7.0.1
 */