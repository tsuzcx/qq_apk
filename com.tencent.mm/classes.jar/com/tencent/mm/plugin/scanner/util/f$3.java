package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;

final class f$3
  implements DialogInterface.OnCancelListener
{
  f$3(f paramf, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81395);
    g.Rc().a(this.qCA);
    if (this.qCz.qCw != null) {
      this.qCz.qCw.q(1, null);
    }
    AppMethodBeat.o(81395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.3
 * JD-Core Version:    0.7.0.1
 */