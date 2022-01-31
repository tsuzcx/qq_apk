package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;

final class c$7
  implements DialogInterface.OnClickListener
{
  c$7(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43477);
    paramDialogInterface = new Intent();
    ((b)g.E(b.class)).b(this.pmw.mActivity, paramDialogInterface);
    AppMethodBeat.o(43477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.7
 * JD-Core Version:    0.7.0.1
 */