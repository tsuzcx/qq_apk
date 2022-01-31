package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$10
  implements DialogInterface.OnCancelListener
{
  WalletPayUI$10(WalletPayUI paramWalletPayUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    int i = 0;
    AppMethodBeat.i(46045);
    ab.i(this.tXq.TAG, "WalletPwdDialog event2 %s", new Object[] { bo.dtY().toString() });
    WalletPayUI.l(this.tXq);
    WalletPayUI.j(this.tXq);
    if (this.tXq.mPayInfo == null) {
      if (this.tXq.mPayInfo != null) {
        break label151;
      }
    }
    label151:
    for (String str = "";; str = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, str, 10, "");
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      this.tXq.gJv = null;
      this.tXq.tWX = null;
      if (this.tXq.isTransparent()) {
        this.tXq.finish();
      }
      this.tXq.tVS = null;
      AppMethodBeat.o(46045);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.10
 * JD-Core Version:    0.7.0.1
 */