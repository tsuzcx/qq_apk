package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$16$2
  implements DialogInterface.OnClickListener
{
  j$16$2(j.16 param16) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32333);
    if (paramDialogInterface != null) {
      paramDialogInterface.cancel();
    }
    AppMethodBeat.o(32333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.16.2
 * JD-Core Version:    0.7.0.1
 */