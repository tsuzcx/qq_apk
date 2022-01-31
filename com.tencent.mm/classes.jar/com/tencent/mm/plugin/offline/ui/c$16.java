package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$16
  implements DialogInterface.OnClickListener
{
  c$16(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43486);
    h.am(this.pmw.mActivity, 0);
    ab.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
    AppMethodBeat.o(43486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.16
 * JD-Core Version:    0.7.0.1
 */