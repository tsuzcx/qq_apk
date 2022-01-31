package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    a.F(this.mMg.mActivity);
    y.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.5
 * JD-Core Version:    0.7.0.1
 */