package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class af$4
  implements DialogInterface.OnClickListener
{
  af$4(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31634);
    if (af.a(this.zHr) != null) {
      af.a(this.zHr).dismiss();
    }
    AppMethodBeat.o(31634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af.4
 * JD-Core Version:    0.7.0.1
 */