package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$11
  implements DialogInterface.OnClickListener
{
  f$11(f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(81403);
    if (this.qCz.qCw != null) {
      this.qCz.qCw.q(1, null);
    }
    AppMethodBeat.o(81403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.11
 * JD-Core Version:    0.7.0.1
 */