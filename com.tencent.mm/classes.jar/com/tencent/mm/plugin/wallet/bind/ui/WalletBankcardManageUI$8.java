package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardManageUI$8
  implements View.OnClickListener
{
  WalletBankcardManageUI$8(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69108);
    if (!bs.isNullOrNil(this.BfQ.BuW))
    {
      e.n(this.BfN.getContext(), this.BfQ.BuW, false);
      h.wUl.f(14422, new Object[] { Integer.valueOf(6) });
    }
    AppMethodBeat.o(69108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.8
 * JD-Core Version:    0.7.0.1
 */