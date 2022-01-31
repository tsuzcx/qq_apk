package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$12
  implements View.OnClickListener
{
  WalletBalanceManagerUI$12(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142286);
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
    paramView.putExtra("showShare", false);
    paramView.putExtra("geta8key_username", r.Zn());
    d.b(this.tOJ, "webview", ".ui.tools.WebViewUI", paramView);
    e.RX(17);
    AppMethodBeat.o(142286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12
 * JD-Core Version:    0.7.0.1
 */