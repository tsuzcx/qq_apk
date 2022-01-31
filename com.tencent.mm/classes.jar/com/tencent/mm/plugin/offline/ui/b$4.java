package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class b$4
  implements DialogInterface.OnClickListener
{
  b$4(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.val$activity instanceof WalletOfflineCoinPurseUI)) {
      ((WalletOfflineCoinPurseUI)this.val$activity).mNf = false;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b.4
 * JD-Core Version:    0.7.0.1
 */