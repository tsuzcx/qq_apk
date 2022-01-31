package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ah$c$2
  implements DialogInterface.OnClickListener
{
  ah$c$2(ah.d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6661);
    this.uVR.goBack();
    AppMethodBeat.o(6661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.2
 * JD-Core Version:    0.7.0.1
 */