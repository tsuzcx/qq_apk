package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.aa;
import com.tencent.mm.plugin.wallet.balance.a.a.aa.a;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletLqtSaveFetchUI$13
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$13(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155086);
    if (bo.av(WalletLqtSaveFetchUI.t(this.tRZ)) < 800L)
    {
      ab.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
      AppMethodBeat.o(155086);
      return;
    }
    WalletLqtSaveFetchUI.a(this.tRZ, bo.yB());
    int j = WalletLqtSaveFetchUI.gY(WalletLqtSaveFetchUI.h(this.tRZ).getText(), "100");
    if (j > 0)
    {
      this.tRZ.hideWcKb();
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 1)
      {
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
        if (WalletLqtSaveFetchUI.c(this.tRZ, p.tMy.tMv))
        {
          AppMethodBeat.o(155086);
          return;
        }
        paramView = WalletLqtSaveFetchUI.v(this.tRZ).tNt;
        f.h(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.u(this.tRZ)), WalletLqtSaveFetchUI.i(this.tRZ)).c(paramView).f(new WalletLqtSaveFetchUI.13.2(this, j)).a(new WalletLqtSaveFetchUI.13.1(this));
        AppMethodBeat.o(155086);
        return;
      }
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 2)
      {
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
        if (WalletLqtSaveFetchUI.c(this.tRZ, p.tMy.tMw))
        {
          AppMethodBeat.o(155086);
          return;
        }
        aa.a locala = null;
        paramView = locala;
        if (WalletLqtSaveFetchUI.i(this.tRZ) != null)
        {
          paramView = locala;
          if (!WalletLqtSaveFetchUI.i(this.tRZ).cTf())
          {
            paramView = new hd();
            paramView.nLq = WalletLqtSaveFetchUI.i(this.tRZ).field_bankName;
            paramView.poq = WalletLqtSaveFetchUI.i(this.tRZ).field_bankcardType;
            paramView.wtS = WalletLqtSaveFetchUI.i(this.tRZ).field_bindSerial;
            paramView.ppo = WalletLqtSaveFetchUI.i(this.tRZ).field_bankcardTail;
          }
        }
        int i = -1;
        if (WalletLqtSaveFetchUI.f(this.tRZ).getSelectRedeemType() != null) {
          i = WalletLqtSaveFetchUI.f(this.tRZ).getSelectRedeemType().xBD;
        }
        locala = WalletLqtSaveFetchUI.v(this.tRZ).tNu;
        f.b(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.u(this.tRZ)), Integer.valueOf(i), paramView).c(locala).f(new WalletLqtSaveFetchUI.13.4(this, j)).a(new WalletLqtSaveFetchUI.13.3(this));
      }
    }
    AppMethodBeat.o(155086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13
 * JD-Core Version:    0.7.0.1
 */