package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$24
  implements View.OnClickListener
{
  WalletLqtDetailUI$24(WalletLqtDetailUI paramWalletLqtDetailUI, bsy parambsy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68813);
    e.v(this.zJb.CRC, this.zJb.DcE, 0, 1061);
    h.vKh.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.zJb.DcE, this.zJb.CRC });
    AppMethodBeat.o(68813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.24
 * JD-Core Version:    0.7.0.1
 */