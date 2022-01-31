package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;

final class c$12
  implements DialogInterface.OnClickListener
{
  c$12(c paramc, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23467);
    this.car.field_hadAlert = 1;
    this.pzT.a(this.car, false);
    AppMethodBeat.o(23467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.12
 * JD-Core Version:    0.7.0.1
 */