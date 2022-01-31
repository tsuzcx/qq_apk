package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$11
  implements DialogInterface.OnCancelListener
{
  h$11(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(106413);
    if (this.uZK != null) {
      this.uZK.onClick(paramDialogInterface, 0);
    }
    AppMethodBeat.o(106413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.11
 * JD-Core Version:    0.7.0.1
 */