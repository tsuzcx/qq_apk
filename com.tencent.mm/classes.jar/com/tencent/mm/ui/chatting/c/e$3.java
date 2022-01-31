package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class e$3
  implements DialogInterface.OnCancelListener
{
  e$3(e parame, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31245);
    this.efL.cancel();
    AppMethodBeat.o(31245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e.3
 * JD-Core Version:    0.7.0.1
 */