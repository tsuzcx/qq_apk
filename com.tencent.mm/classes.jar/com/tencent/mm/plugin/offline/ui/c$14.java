package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$14
  implements DialogInterface.OnCancelListener
{
  c$14(c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(43484);
    this.pmw.bYS();
    AppMethodBeat.o(43484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.14
 * JD-Core Version:    0.7.0.1
 */