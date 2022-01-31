package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.n;

final class p$7$1
  implements DialogInterface.OnClickListener
{
  p$7$1(p.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(81207);
    this.qAh.qAf.qzT = false;
    this.qAh.qAf.qzU = false;
    n.qux.reset();
    n.qux.CE(n.quu);
    if (this.qAh.qAf.qzg != null)
    {
      this.qAh.qAf.qzg.kA(false);
      this.qAh.qAf.qzg.lf(this.qAh.qAf.qzv);
    }
    AppMethodBeat.o(81207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.7.1
 * JD-Core Version:    0.7.0.1
 */