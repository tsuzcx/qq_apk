package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ClearCacheUI$2
  implements DialogInterface.OnClickListener
{
  ClearCacheUI$2(ClearCacheUI paramClearCacheUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29166);
    this.yUX.finish();
    AppMethodBeat.o(29166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.2
 * JD-Core Version:    0.7.0.1
 */