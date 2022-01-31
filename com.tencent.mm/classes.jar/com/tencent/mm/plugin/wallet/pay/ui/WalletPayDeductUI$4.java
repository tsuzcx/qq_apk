package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletPayDeductUI$4
  implements View.OnClickListener
{
  WalletPayDeductUI$4(WalletPayDeductUI paramWalletPayDeductUI, Orders.DeductShowInfo paramDeductShowInfo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46021);
    ab.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.tWz.ukd) });
    if (this.tWz.ukd == 1)
    {
      if (!bo.isNullOrNil(this.tWz.ukg))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.tWz.ukg);
        paramView.putExtra("showShare", false);
        d.b(this.tWw, "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(46021);
      }
    }
    else if (this.tWz.ukd == 2)
    {
      paramView = new so();
      paramView.cIQ.userName = this.tWz.uke;
      paramView.cIQ.cIS = bo.bf(this.tWz.ukf, "");
      paramView.cIQ.scene = 1097;
      paramView.cIQ.cIT = 0;
      a.ymk.l(paramView);
    }
    AppMethodBeat.o(46021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.4
 * JD-Core Version:    0.7.0.1
 */