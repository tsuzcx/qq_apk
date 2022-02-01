package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$2
  implements DialogInterface.OnClickListener
{
  q$2(q paramq, boolean paramBoolean, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163285);
    if (this.WAx)
    {
      q.Q(12, this.WAy, q.l(this.WAw));
      AppMethodBeat.o(163285);
      return;
    }
    q.Q(9, this.WAy, q.l(this.WAw));
    AppMethodBeat.o(163285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.2
 * JD-Core Version:    0.7.0.1
 */