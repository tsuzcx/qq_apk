package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;

public final class a$1
  implements DialogInterface.OnCancelListener
{
  public a$1(a parama, com.tencent.mm.plugin.scanner.model.g paramg) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81367);
    this.qBX.cjl();
    com.tencent.mm.kernel.g.Rc().a(this.qBW);
    AppMethodBeat.o(81367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.1
 * JD-Core Version:    0.7.0.1
 */