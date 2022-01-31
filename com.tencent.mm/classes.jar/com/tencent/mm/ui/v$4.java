package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class v$4
  implements DialogInterface.OnCancelListener
{
  v$4(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29598);
    h.qsU.idkeyStat(405L, 37L, 1L, true);
    this.gjR.finish();
    MMAppMgr.l(this.gjR, true);
    AppMethodBeat.o(29598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.v.4
 * JD-Core Version:    0.7.0.1
 */