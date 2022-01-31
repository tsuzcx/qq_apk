package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletPayUI$9
  implements View.OnClickListener
{
  WalletPayUI$9(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46044);
    ab.i(this.tXq.TAG, "WalletPwdDialog event1 %s", new Object[] { bo.dtY().toString() });
    this.tXq.tVQ = ((FavorPayInfo)paramView.getTag());
    if (this.tXq.tVQ != null) {
      this.tXq.tVQ.uhY = "";
    }
    this.tXq.c(false, 0, "");
    this.tXq.tWX.dismiss();
    this.tXq.gJv = null;
    this.tXq.tWX = null;
    this.tXq.tVS = null;
    AppMethodBeat.o(46044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.9
 * JD-Core Version:    0.7.0.1
 */