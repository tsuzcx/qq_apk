package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;

final class a$2
  implements DialogInterface.OnDismissListener
{
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(184241);
    as.d("dancy", "OnDismissListener ", new Object[0]);
    AppMethodBeat.o(184241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.2
 * JD-Core Version:    0.7.0.1
 */