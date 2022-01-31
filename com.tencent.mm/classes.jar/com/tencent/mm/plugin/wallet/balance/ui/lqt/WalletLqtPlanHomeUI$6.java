package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class WalletLqtPlanHomeUI$6
  implements n.d
{
  WalletLqtPlanHomeUI$6(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, bmo parambmo) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(45610);
    paramInt = paramMenuItem.getItemId();
    WalletLqtPlanHomeUI.a(this.tQV, paramInt);
    WalletLqtPlanHomeUI.b(this.tQV, this.tQY.wpg);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45610);
      return;
      WalletLqtPlanHomeUI.c(this.tQV, paramInt);
      AppMethodBeat.o(45610);
      return;
      h.a(this.tQV.getContext(), this.tQV.getString(2131305272), "", this.tQV.getString(2131305271), this.tQV.getString(2131296888), true, new WalletLqtPlanHomeUI.6.1(this, paramInt), new WalletLqtPlanHomeUI.6.2(this), 2131690393);
      AppMethodBeat.o(45610);
      return;
      WalletLqtPlanHomeUI.c(this.tQV, paramInt);
      AppMethodBeat.o(45610);
      return;
      WalletLqtPlanHomeUI.a(this.tQV, this.tQY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.6
 * JD-Core Version:    0.7.0.1
 */