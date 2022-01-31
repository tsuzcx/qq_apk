package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.y;

final class c$12
  implements DialogInterface.OnClickListener
{
  c$12(c paramc, s.g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.mMg.mMb != null) {
      this.mMg.mMb.d(0, this.mMh.id, "", this.mMh.bOT);
    }
    g.ce(this.mMh.bOT, g.mJV);
    y.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.12
 * JD-Core Version:    0.7.0.1
 */