package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtSaveFetchUI$27
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$27(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, afu paramafu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187125);
    if (this.zMs.DfJ.DPZ != 1)
    {
      if (this.zMs.DfJ.DPZ == 2)
      {
        e.aS(this.zMe.getContext(), this.zMs.DfJ.DcE);
        AppMethodBeat.o(187125);
        return;
      }
      if (this.zMs.DfJ.DPZ == 3) {
        e.v(this.zMs.DfJ.CRC, this.zMs.DfJ.DcE, 0, 1061);
      }
    }
    AppMethodBeat.o(187125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.27
 * JD-Core Version:    0.7.0.1
 */