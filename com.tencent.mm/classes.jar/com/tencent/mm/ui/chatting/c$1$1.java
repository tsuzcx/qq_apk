package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class c$1$1
  implements DialogInterface.OnCancelListener
{
  c$1$1(c.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30378);
    aw.Rc().b(1030, this.zwn.zwm);
    AppMethodBeat.o(30378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.1.1
 * JD-Core Version:    0.7.0.1
 */