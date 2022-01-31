package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$10
  implements DialogInterface.OnClickListener
{
  f$10(f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(81402);
    if (this.qCz.qCw != null) {
      this.qCz.qCw.q(1, null);
    }
    AppMethodBeat.o(81402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.10
 * JD-Core Version:    0.7.0.1
 */