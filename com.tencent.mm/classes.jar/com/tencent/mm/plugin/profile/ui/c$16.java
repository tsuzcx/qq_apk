package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.aj.z;

final class c$16
  implements DialogInterface.OnCancelListener
{
  c$16(c paramc, y paramy) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(23471);
    z.afr();
    com.tencent.mm.aj.c.a(this.pzX);
    AppMethodBeat.o(23471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.16
 * JD-Core Version:    0.7.0.1
 */