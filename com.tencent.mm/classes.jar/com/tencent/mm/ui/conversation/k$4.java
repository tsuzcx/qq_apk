package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$4
  implements DialogInterface.OnClickListener
{
  k$4(k paramk) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38593);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(38593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.4
 * JD-Core Version:    0.7.0.1
 */