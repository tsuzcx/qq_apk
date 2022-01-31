package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab$2
  implements DialogInterface.OnClickListener
{
  ab$2(ab paramab) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29840);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ab.2
 * JD-Core Version:    0.7.0.1
 */