package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletBankcardManageUI$7
  implements View.OnClickListener
{
  WalletBankcardManageUI$7(WalletBankcardManageUI paramWalletBankcardManageUI, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45769);
    paramView = new so();
    paramView.cIQ.userName = this.tTm.ugv;
    paramView.cIQ.cIS = bo.bf(this.tTm.ugw, "");
    paramView.cIQ.scene = 1071;
    paramView.cIQ.cIT = 0;
    a.ymk.l(paramView);
    AppMethodBeat.o(45769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.7
 * JD-Core Version:    0.7.0.1
 */