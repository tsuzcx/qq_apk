package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43474);
    this.pmw.pmr.bYO();
    ab.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
    AppMethodBeat.o(43474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.3
 * JD-Core Version:    0.7.0.1
 */