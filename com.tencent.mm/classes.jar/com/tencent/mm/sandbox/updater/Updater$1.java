package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;

final class Updater$1
  implements DialogInterface.OnCancelListener
{
  Updater$1(Updater paramUpdater, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28931);
    aw.getNotification().cancel(99);
    h.qsU.idkeyStat(405L, 47L, 1L, true);
    Updater.MX(2);
    this.yls.onStop();
    if ((!Updater.a(this.yls)) && (this.ylt != null)) {
      this.ylt.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(28931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.1
 * JD-Core Version:    0.7.0.1
 */