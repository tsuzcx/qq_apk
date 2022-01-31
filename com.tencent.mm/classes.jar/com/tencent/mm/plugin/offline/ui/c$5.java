package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43475);
    paramDialogInterface.dismiss();
    a.aa(this.pmw.mActivity);
    ab.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
    AppMethodBeat.o(43475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.5
 * JD-Core Version:    0.7.0.1
 */