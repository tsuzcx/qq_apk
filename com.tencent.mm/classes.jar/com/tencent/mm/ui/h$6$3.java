package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$6$3
  implements DialogInterface.OnClickListener
{
  h$6$3(h.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29315);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.h.6.3
 * JD-Core Version:    0.7.0.1
 */