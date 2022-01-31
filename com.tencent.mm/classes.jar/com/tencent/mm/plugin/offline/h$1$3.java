package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;

final class h$1$3
  implements DialogInterface.OnClickListener
{
  h$1$3(h.1 param1, MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43326);
    this.pkt.pks.a(this.val$activity, 0, h.n(this.pkt.pks));
    AppMethodBeat.o(43326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h.1.3
 * JD-Core Version:    0.7.0.1
 */