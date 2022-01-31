package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Date;

final class WalletBankcardManageUI$8
  implements View.OnClickListener
{
  final int qkn = 1000;
  
  WalletBankcardManageUI$8(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.f.wallet_entrance_add_bankcard)
    {
      paramView = com.tencent.mm.plugin.wallet_core.model.g.bUY();
      if (paramView.akH()) {
        com.tencent.mm.ui.base.h.b(this.qkk, paramView.mOd, this.qkk.getString(a.i.app_tip), true);
      }
    }
    do
    {
      Object localObject;
      long l;
      do
      {
        return;
        com.tencent.mm.wallet_core.ui.e.Jc(19);
        this.qkk.bTE();
        com.tencent.mm.plugin.report.service.h.nFQ.f(14422, new Object[] { Integer.valueOf(2) });
        return;
        if (paramView.getId() != a.f.wallet_entrance_loan) {
          break;
        }
        localObject = paramView.getTag();
        l = new Date().getTime();
        paramView.setTag(Long.valueOf(l));
      } while ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L));
      paramView = new Intent();
      paramView.putExtra("rawUrl", WalletBankcardManageUI.a(this.qkk).field_loan_jump_url);
      d.b(this.qkk, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqT, Integer.valueOf(WalletBankcardManageUI.a(this.qkk).field_red_dot_index));
      com.tencent.mm.wallet_core.ui.e.Jc(6);
      return;
    } while (paramView.getId() != a.f.bank_card_help);
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
    d.b(this.qkk, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14422, new Object[] { Integer.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.8
 * JD-Core Version:    0.7.0.1
 */