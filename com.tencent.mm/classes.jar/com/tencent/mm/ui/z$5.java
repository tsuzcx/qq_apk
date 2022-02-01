package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class z$5
  implements DialogInterface.OnCancelListener
{
  z$5(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33442);
    h.CyF.idkeyStat(405L, 37L, 1L, true);
    this.dnO.finish();
    MMAppMgr.n(this.dnO, true);
    AppMethodBeat.o(33442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.z.5
 * JD-Core Version:    0.7.0.1
 */