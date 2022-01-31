package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.x;
import com.tencent.mm.model.aw;

final class c$6
  implements DialogInterface.OnCancelListener
{
  c$6(c paramc, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31197);
    aw.Rc().a(this.zuw);
    AppMethodBeat.o(31197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.6
 * JD-Core Version:    0.7.0.1
 */