package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;

final class Updater$1
  implements DialogInterface.OnCancelListener
{
  Updater$1(Updater paramUpdater, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.getNotification().cancel(99);
    h.nFQ.a(405L, 47L, 1L, true);
    Updater.EW(2);
    this.udd.onStop();
    if ((!Updater.a(this.udd)) && (this.ude != null)) {
      this.ude.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.1
 * JD-Core Version:    0.7.0.1
 */