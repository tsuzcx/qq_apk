package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j;

final class ar$4
  implements DialogInterface.OnCancelListener
{
  ar$4(ar paramar, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31848);
    this.zJg.dlb();
    AppMethodBeat.o(31848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ar.4
 * JD-Core Version:    0.7.0.1
 */