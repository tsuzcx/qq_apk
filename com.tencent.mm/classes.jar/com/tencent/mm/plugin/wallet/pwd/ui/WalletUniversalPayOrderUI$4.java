package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.wallet_core.ui.e;

final class WalletUniversalPayOrderUI$4
  implements o.a
{
  WalletUniversalPayOrderUI$4(WalletUniversalPayOrderUI paramWalletUniversalPayOrderUI, cml paramcml) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(46429);
    e.m(this.ubc.getContext(), this.ubd.xWh.url, true);
    h.qsU.e(16343, new Object[] { Integer.valueOf(11) });
    AppMethodBeat.o(46429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.4
 * JD-Core Version:    0.7.0.1
 */