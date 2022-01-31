package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.b;

final class v$5
  implements DialogInterface.OnCancelListener
{
  v$5(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29599);
    h.qsU.idkeyStat(405L, 39L, 1L, true);
    if (this.zbT != null)
    {
      this.gjR.finish();
      this.gjR.startActivity(this.zbT);
      b.K(this.gjR, this.zbT);
    }
    AppMethodBeat.o(29599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.v.5
 * JD-Core Version:    0.7.0.1
 */