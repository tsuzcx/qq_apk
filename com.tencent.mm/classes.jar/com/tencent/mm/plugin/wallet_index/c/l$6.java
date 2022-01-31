package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;

final class l$6
  implements DialogInterface.OnClickListener
{
  l$6(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48204);
    if (this.uAp.uAl.callback != null)
    {
      this.uAp.uAl.cwo.ret = 1;
      this.uAp.uAl.callback.run();
    }
    AppMethodBeat.o(48204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.l.6
 * JD-Core Version:    0.7.0.1
 */