package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class j$5$1$2
  implements DialogInterface.OnClickListener
{
  j$5$1$2(j.5.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34467);
    h.qsU.idkeyStat(614L, 57L, 1L, false);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(34467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.5.1.2
 * JD-Core Version:    0.7.0.1
 */