package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.a.y;
import com.tencent.mm.model.ba;

final class c$7
  implements DialogInterface.OnCancelListener
{
  c$7(c paramc, y paramy) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35089);
    ba.aiU().a(this.Jwh);
    AppMethodBeat.o(35089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.7
 * JD-Core Version:    0.7.0.1
 */