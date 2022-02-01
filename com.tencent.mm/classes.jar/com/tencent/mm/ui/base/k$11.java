package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$11
  implements DialogInterface.OnCancelListener
{
  public k$11(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(251308);
    if (this.WRL != null) {
      this.WRL.onClick(paramDialogInterface, 0);
    }
    AppMethodBeat.o(251308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.k.11
 * JD-Core Version:    0.7.0.1
 */