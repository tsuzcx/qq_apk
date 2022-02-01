package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class MMAppMgr$1
  implements DialogInterface.OnClickListener
{
  MMAppMgr$1(int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33403);
    bg.aVF();
    c.azQ().set(65, Integer.valueOf(this.jeE + 1));
    AppMethodBeat.o(33403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.1
 * JD-Core Version:    0.7.0.1
 */