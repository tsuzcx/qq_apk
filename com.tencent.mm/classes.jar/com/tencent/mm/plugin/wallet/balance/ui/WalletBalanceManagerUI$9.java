package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$9
  implements View.OnClickListener
{
  WalletBalanceManagerUI$9(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
    paramView.putExtra("showShare", false);
    paramView.putExtra("geta8key_username", q.Gj());
    d.b(this.qhk, "webview", ".ui.tools.WebViewUI", paramView);
    e.Jc(17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.9
 * JD-Core Version:    0.7.0.1
 */