package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$7
  implements View.OnClickListener
{
  WalletLqtDetailUI$7(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68793);
    ad.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.zIT).EaZ.DPZ == 2)
    {
      if (!bt.isNullOrNil(WalletLqtDetailUI.d(this.zIT).EaZ.DcE))
      {
        e.o(this.zIT, WalletLqtDetailUI.d(this.zIT).EaZ.DcE, false);
        h.vKh.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.zIT).EaZ.DcE });
        AppMethodBeat.o(68793);
      }
    }
    else if ((WalletLqtDetailUI.d(this.zIT).EaZ.DPZ == 3) && (!bt.isNullOrNil(WalletLqtDetailUI.d(this.zIT).EaZ.CRC)) && (!bt.isNullOrNil(WalletLqtDetailUI.d(this.zIT).EaZ.DcE)))
    {
      e.v(WalletLqtDetailUI.d(this.zIT).EaZ.CRC, WalletLqtDetailUI.d(this.zIT).EaZ.DcE, 0, 1061);
      h.vKh.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.zIT).EaZ.DcE, WalletLqtDetailUI.d(this.zIT).EaZ.CRC });
    }
    AppMethodBeat.o(68793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.7
 * JD-Core Version:    0.7.0.1
 */