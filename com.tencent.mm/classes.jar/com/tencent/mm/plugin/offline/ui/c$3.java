package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(66373);
    this.ulg.ulb.cYA();
    ad.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
    AppMethodBeat.o(66373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.3
 * JD-Core Version:    0.7.0.1
 */