package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class h$5
  implements DialogInterface.OnClickListener
{
  h$5(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29312);
    al.d(new h.5.1(this, paramDialogInterface));
    AppMethodBeat.o(29312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.h.5
 * JD-Core Version:    0.7.0.1
 */