package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class k$3
  implements DialogInterface.OnCancelListener
{
  k$3(Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
    if ((this.oof != null) && (this.oof.isShowing())) {
      this.oof.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.3
 * JD-Core Version:    0.7.0.1
 */