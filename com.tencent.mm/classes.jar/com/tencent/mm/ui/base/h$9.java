package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$9
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(106411);
    paramDialogInterface.cancel();
    AppMethodBeat.o(106411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.9
 * JD-Core Version:    0.7.0.1
 */