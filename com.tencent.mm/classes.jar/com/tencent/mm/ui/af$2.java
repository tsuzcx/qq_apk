package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class af$2
  implements DialogInterface.OnClickListener
{
  af$2(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33687);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(33687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.af.2
 * JD-Core Version:    0.7.0.1
 */