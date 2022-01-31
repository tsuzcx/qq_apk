package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$18
  implements DialogInterface.OnClickListener
{
  c$18(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.Y(this.mMg.mActivity, 0);
    y.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.18
 * JD-Core Version:    0.7.0.1
 */