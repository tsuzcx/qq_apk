package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class an$3
  implements DialogInterface.OnClickListener
{
  an$3(an paraman) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31750);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(31750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an.3
 * JD-Core Version:    0.7.0.1
 */