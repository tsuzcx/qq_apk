package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtSaveFetchUI$33
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$33(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, agt paramagt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207243);
    if (this.BeM.EyP.Fmq != 1)
    {
      if (this.BeM.EyP.Fmq == 2)
      {
        e.aT(this.Beu.getContext(), this.BeM.EyP.EvL);
        AppMethodBeat.o(207243);
        return;
      }
      if (this.BeM.EyP.Fmq == 3) {
        e.v(this.BeM.EyP.Ekn, this.BeM.EyP.EvL, 0, 1061);
      }
    }
    AppMethodBeat.o(207243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.33
 * JD-Core Version:    0.7.0.1
 */