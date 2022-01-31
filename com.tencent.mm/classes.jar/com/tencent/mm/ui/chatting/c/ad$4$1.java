package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class ad$4$1
  implements DialogInterface.OnCancelListener
{
  ad$4$1(ad.4 param4, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31616);
    this.zHm.cancel();
    AppMethodBeat.o(31616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ad.4.1
 * JD-Core Version:    0.7.0.1
 */