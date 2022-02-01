package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$7
  implements View.OnClickListener
{
  WalletLqtDetailUI$7(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68793);
    ac.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.Bbf).FxU.Fmq == 2)
    {
      if (!bs.isNullOrNil(WalletLqtDetailUI.d(this.Bbf).FxU.EvL))
      {
        e.n(this.Bbf, WalletLqtDetailUI.d(this.Bbf).FxU.EvL, false);
        h.wUl.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.Bbf).FxU.EvL });
        AppMethodBeat.o(68793);
      }
    }
    else if ((WalletLqtDetailUI.d(this.Bbf).FxU.Fmq == 3) && (!bs.isNullOrNil(WalletLqtDetailUI.d(this.Bbf).FxU.Ekn)) && (!bs.isNullOrNil(WalletLqtDetailUI.d(this.Bbf).FxU.EvL)))
    {
      e.v(WalletLqtDetailUI.d(this.Bbf).FxU.Ekn, WalletLqtDetailUI.d(this.Bbf).FxU.EvL, 0, 1061);
      h.wUl.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.Bbf).FxU.EvL, WalletLqtDetailUI.d(this.Bbf).FxU.Ekn });
    }
    AppMethodBeat.o(68793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.7
 * JD-Core Version:    0.7.0.1
 */