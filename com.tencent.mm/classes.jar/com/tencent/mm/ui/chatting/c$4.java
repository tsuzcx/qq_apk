package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.d;

final class c$4
  implements DialogInterface.OnCancelListener
{
  c$4(c paramc, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30382);
    aw.Rc().a(this.ckS);
    al.caf().b(2, this.zwm);
    AppMethodBeat.o(30382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.4
 * JD-Core Version:    0.7.0.1
 */