package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class WalletOfflineCoinPurseUI$21
  implements DialogInterface.OnClickListener
{
  WalletOfflineCoinPurseUI$21(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    a.a(this.mNj, 0, WalletOfflineCoinPurseUI.b(this.mNj));
    WalletOfflineCoinPurseUI.I(this.mNj);
    y.v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.21
 * JD-Core Version:    0.7.0.1
 */