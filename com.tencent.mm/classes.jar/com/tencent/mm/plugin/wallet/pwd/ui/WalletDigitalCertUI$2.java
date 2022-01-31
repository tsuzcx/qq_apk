package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.d;

final class WalletDigitalCertUI$2
  extends d
{
  WalletDigitalCertUI$2(WalletDigitalCertUI paramWalletDigitalCertUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46252);
    ab.dSv();
    paramView = new m(ab.getCrtNo());
    this.tYR.doSceneProgress(paramView);
    h.qsU.e(13731, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(46252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.2
 * JD-Core Version:    0.7.0.1
 */