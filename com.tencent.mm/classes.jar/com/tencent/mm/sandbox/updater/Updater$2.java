package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.service.h;

final class Updater$2
  implements DialogInterface.OnCancelListener
{
  Updater$2(Updater paramUpdater, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(32745);
    bh.getNotification().cancel(99);
    h.OAn.idkeyStat(405L, 49L, 1L, true);
    Updater.axW(2);
    this.acom.onStop();
    if ((!Updater.a(this.acom)) && (this.acon != null)) {
      this.acon.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(32745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.2
 * JD-Core Version:    0.7.0.1
 */