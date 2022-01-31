package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements DialogInterface.OnKeyListener
{
  c$2(c paramc, String paramString) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80908);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      c.a(this.qvF, this.iaF);
      AppMethodBeat.o(80908);
      return true;
    }
    AppMethodBeat.o(80908);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c.2
 * JD-Core Version:    0.7.0.1
 */