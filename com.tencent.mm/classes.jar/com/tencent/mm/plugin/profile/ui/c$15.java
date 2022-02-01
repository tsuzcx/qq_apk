package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;

final class c$15
  implements DialogInterface.OnCancelListener
{
  c$15(c paramc, com.tencent.mm.plugin.profile.b.c paramc1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27085);
    ba.aiU().a(this.wRH);
    ba.aiU().b(1363, this.wRE);
    AppMethodBeat.o(27085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.15
 * JD-Core Version:    0.7.0.1
 */