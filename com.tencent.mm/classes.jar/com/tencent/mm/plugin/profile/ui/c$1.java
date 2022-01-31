package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(c paramc, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23456);
    this.car.field_hadAlert = 1;
    this.car.field_brandFlag |= 0x4;
    this.pzT.a(this.car, true);
    AppMethodBeat.o(23456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.1
 * JD-Core Version:    0.7.0.1
 */