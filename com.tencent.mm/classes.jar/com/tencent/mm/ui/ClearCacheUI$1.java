package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ClearCacheUI$1
  implements DialogInterface.OnClickListener
{
  ClearCacheUI$1(ClearCacheUI paramClearCacheUI, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29165);
    ClearCacheUI.a(this.yUX, this.yUW);
    this.yUX.finish();
    AppMethodBeat.o(29165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.1
 * JD-Core Version:    0.7.0.1
 */