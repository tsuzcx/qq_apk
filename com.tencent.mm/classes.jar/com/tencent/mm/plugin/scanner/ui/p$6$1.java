package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class p$6$1
  implements DialogInterface.OnCancelListener
{
  p$6$1(p.6 param6) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81205);
    this.qAg.qAf.qzT = false;
    this.qAg.qAf.qzS.set(false);
    this.qAg.qAf.qzU = false;
    AppMethodBeat.o(81205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.6.1
 * JD-Core Version:    0.7.0.1
 */