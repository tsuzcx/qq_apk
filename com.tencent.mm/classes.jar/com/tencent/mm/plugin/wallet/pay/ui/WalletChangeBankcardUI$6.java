package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.q;

final class WalletChangeBankcardUI$6
  implements View.OnClickListener
{
  WalletChangeBankcardUI$6(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45963);
    if (this.tVU.tVM != null) {
      this.tVU.tVM.dismiss();
    }
    this.tVU.nx(false);
    this.tVU.tVO.g(this.tVU.tNG, true);
    this.tVU.tVQ = ((FavorPayInfo)paramView.getTag());
    if (this.tVU.tVQ != null) {
      this.tVU.tVQ.uhY = "";
    }
    this.tVU.getInput().putParcelable("key_favor_pay_info", this.tVU.tVQ);
    this.tVU.bJ();
    this.tVU.setContentViewVisibility(0);
    this.tVU.tVS = null;
    AppMethodBeat.o(45963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.6
 * JD-Core Version:    0.7.0.1
 */