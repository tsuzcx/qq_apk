package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class WalletLqtPlanHomeUI$b$2
  implements View.OnClickListener
{
  WalletLqtPlanHomeUI$b$2(WalletLqtPlanHomeUI.b paramb, bmo parambmo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45620);
    if (this.tQY.xAY != null)
    {
      if ((this.tQY.xAY.xth) && (!bo.isNullOrNil(this.tQY.xAY.xti)))
      {
        h.a(this.tRj.tQV.getContext(), this.tQY.xAY.xti, "", this.tRj.tQV.getString(2131296977), new WalletLqtPlanHomeUI.b.2.1(this));
        AppMethodBeat.o(45620);
        return;
      }
      WalletLqtPlanHomeUI.a(this.tRj.tQV, this.tQY.xAY.xtj, this.tQY);
    }
    AppMethodBeat.o(45620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.b.2
 * JD-Core Version:    0.7.0.1
 */