package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24103);
    b.f(8192, false, 12);
    b.f(64, false, 5);
    AppMethodBeat.o(24103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.1
 * JD-Core Version:    0.7.0.1
 */