package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class g$6
  implements DialogInterface.OnClickListener
{
  g$6(String paramString1, String paramString2, String paramString3, ai paramai) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151613);
    h.qsU.e(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), this.Cl, this.vLd, this.vLe });
    if (this.kZN != null) {
      this.kZN.dZ(false);
    }
    AppMethodBeat.o(151613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.6
 * JD-Core Version:    0.7.0.1
 */