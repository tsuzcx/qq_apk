package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k;

final class l$5
  implements l.a.a
{
  l$5(k paramk, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(28135);
    if (paramBoolean)
    {
      this.wcv.dismiss();
      if (this.wcs != null) {
        this.wcs.onDismiss(null);
      }
    }
    AppMethodBeat.o(28135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.5
 * JD-Core Version:    0.7.0.1
 */