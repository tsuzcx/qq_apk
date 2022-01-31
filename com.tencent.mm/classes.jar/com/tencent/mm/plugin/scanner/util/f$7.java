package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class f$7
  implements DialogInterface.OnCancelListener
{
  f$7(f paramf, com.tencent.mm.plugin.messenger.a.f paramf1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81399);
    g.Rc().a(this.mWB);
    if (this.qCz.qCw != null) {
      this.qCz.qCw.q(1, null);
    }
    f.a(this.qCz, this.mWB);
    AppMethodBeat.o(81399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.7
 * JD-Core Version:    0.7.0.1
 */