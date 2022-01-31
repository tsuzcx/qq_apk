package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.ab;

final class c$12
  implements DialogInterface.OnClickListener
{
  c$12(c paramc, s.g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43482);
    paramDialogInterface.dismiss();
    if (this.pmw.pmr != null) {
      this.pmw.pmr.e(0, this.pmx.id, "", this.pmx.cwk);
    }
    g.cW(this.pmx.cwk, g.pkk);
    ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    AppMethodBeat.o(43482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.12
 * JD-Core Version:    0.7.0.1
 */