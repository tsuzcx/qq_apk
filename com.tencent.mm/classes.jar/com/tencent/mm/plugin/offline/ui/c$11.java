package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.sdk.platformtools.y;

final class c$11
  implements DialogInterface.OnClickListener
{
  c$11(c paramc, s.g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.mMg.mMb != null) {
      this.mMg.mMb.d(1, this.mMh.id, "", this.mMh.bOT);
    }
    y.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.11
 * JD-Core Version:    0.7.0.1
 */