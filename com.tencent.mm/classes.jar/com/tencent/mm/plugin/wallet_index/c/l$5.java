package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;

final class l$5
  implements DialogInterface.OnClickListener
{
  l$5(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48203);
    if (this.uAp.uAm.callback != null)
    {
      this.uAp.uAm.cCx.ret = 1;
      this.uAp.uAm.callback.run();
    }
    AppMethodBeat.o(48203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.l.5
 * JD-Core Version:    0.7.0.1
 */