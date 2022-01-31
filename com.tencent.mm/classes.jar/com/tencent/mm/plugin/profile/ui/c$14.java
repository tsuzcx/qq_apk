package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.profile.b.d;

final class c$14
  implements DialogInterface.OnCancelListener
{
  c$14(c paramc, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(23469);
    aw.Rc().a(this.jUt);
    aw.Rc().b(1394, this.pzT);
    AppMethodBeat.o(23469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.14
 * JD-Core Version:    0.7.0.1
 */