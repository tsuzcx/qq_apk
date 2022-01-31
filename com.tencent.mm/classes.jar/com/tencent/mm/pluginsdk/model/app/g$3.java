package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class g$3
  implements DialogInterface.OnClickListener
{
  g$3(String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79257);
    h.qsU.e(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.Cl, this.vLd, this.vLe });
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(this.vLf)) {
      h.qsU.e(15413, new Object[] { Integer.valueOf(2), "", "" });
    }
    this.val$run.run();
    AppMethodBeat.o(79257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.3
 * JD-Core Version:    0.7.0.1
 */