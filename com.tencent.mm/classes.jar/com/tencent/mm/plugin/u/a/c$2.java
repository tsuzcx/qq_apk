package com.tencent.mm.plugin.u.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c.a parama, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80758);
    this.pPz.getContext().startActivity(this.pPA);
    AppMethodBeat.o(80758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c.2
 * JD-Core Version:    0.7.0.1
 */