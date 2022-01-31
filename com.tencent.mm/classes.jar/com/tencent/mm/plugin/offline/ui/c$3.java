package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.mMg.mMb.bqi();
    y.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.3
 * JD-Core Version:    0.7.0.1
 */