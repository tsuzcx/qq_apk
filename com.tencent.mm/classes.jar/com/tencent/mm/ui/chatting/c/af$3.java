package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class af$3
  implements DialogInterface.OnClickListener
{
  af$3(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31633);
    if (af.a(this.zHr) != null) {
      af.a(this.zHr).dismiss();
    }
    AppMethodBeat.o(31633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af.3
 * JD-Core Version:    0.7.0.1
 */