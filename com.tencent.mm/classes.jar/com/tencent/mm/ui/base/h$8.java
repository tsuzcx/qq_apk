package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$8
  implements DialogInterface.OnCancelListener
{
  h$8(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(141777);
    if (this.QaB != null) {
      this.QaB.onClick(paramDialogInterface, 0);
    }
    AppMethodBeat.o(141777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.8
 * JD-Core Version:    0.7.0.1
 */