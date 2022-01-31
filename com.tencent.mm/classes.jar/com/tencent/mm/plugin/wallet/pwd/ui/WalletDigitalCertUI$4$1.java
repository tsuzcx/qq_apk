package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletDigitalCertUI$4$1
  implements DialogInterface.OnClickListener
{
  WalletDigitalCertUI$4$1(WalletDigitalCertUI.4 param4, x paramx) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { this.qoF.tNl });
    paramDialogInterface = new k(this.qoF.tNl);
    this.qoG.qoE.a(paramDialogInterface, true, true);
    paramDialogInterface = new aa();
    paramDialogInterface.ckr = 2L;
    paramDialogInterface.cks = 1L;
    paramDialogInterface.QX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4.1
 * JD-Core Version:    0.7.0.1
 */