package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.m;

final class WalletDigitalCertUI$4$1
  implements DialogInterface.OnClickListener
{
  WalletDigitalCertUI$4$1(WalletDigitalCertUI.4 param4, aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46254);
    ab.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { this.tYS.xTJ });
    paramDialogInterface = new m(this.tYS.xTJ);
    this.tYT.tYR.doSceneProgress(paramDialogInterface);
    paramDialogInterface = new bt();
    paramDialogInterface.cRI = 2L;
    paramDialogInterface.cYT = 1L;
    paramDialogInterface.ake();
    AppMethodBeat.o(46254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4.1
 * JD-Core Version:    0.7.0.1
 */