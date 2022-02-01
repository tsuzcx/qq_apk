package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bt;

final class WalletBankcardManageUI$9
  implements View.OnClickListener
{
  WalletBankcardManageUI$9(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69109);
    paramView = new uj();
    paramView.dzH.userName = this.zNw.AcD;
    paramView.dzH.dzJ = bt.by(this.zNw.AcE, "");
    paramView.dzH.scene = 1071;
    paramView.dzH.dzK = 0;
    a.ESL.l(paramView);
    h.vKh.f(14422, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(69109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9
 * JD-Core Version:    0.7.0.1
 */