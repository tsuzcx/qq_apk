package com.tencent.mm.plugin.u.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c.a parama, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80759);
    d.b(this.pPz.getContext(), "freewifi", ".ui.FreeWifiEntryUI", this.etp);
    this.pPz.kn(false);
    AppMethodBeat.o(80759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c.3
 * JD-Core Version:    0.7.0.1
 */