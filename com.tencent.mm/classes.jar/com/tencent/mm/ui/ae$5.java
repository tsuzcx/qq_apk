package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class ae$5
  implements DialogInterface.OnCancelListener
{
  ae$5(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33442);
    h.OAn.idkeyStat(405L, 37L, 1L, true);
    this.hkm.finish();
    MMAppMgr.o(this.hkm, true);
    AppMethodBeat.o(33442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ae.5
 * JD-Core Version:    0.7.0.1
 */