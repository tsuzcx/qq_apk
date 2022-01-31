package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class j$16$1
  implements DialogInterface.OnClickListener
{
  j$16$1(j.16 param16) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32332);
    if (paramDialogInterface != null) {
      paramDialogInterface.cancel();
    }
    al.d(new j.16.1.1(this));
    AppMethodBeat.o(32332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.16.1
 * JD-Core Version:    0.7.0.1
 */