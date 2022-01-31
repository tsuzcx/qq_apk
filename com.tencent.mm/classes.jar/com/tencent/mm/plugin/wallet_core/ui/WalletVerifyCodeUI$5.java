package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

final class WalletVerifyCodeUI$5
  implements View.OnClickListener
{
  WalletVerifyCodeUI$5(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.qHg.cNj();
    int i;
    if ((WalletVerifyCodeUI.a(this.qHg)) && (!(paramView instanceof b)))
    {
      if (this.qge == null) {
        break label213;
      }
      if (this.qge.bUQ()) {
        i = 1;
      }
    }
    for (;;)
    {
      paramView = new c.a(this.qHg.mController.uMN);
      paramView.Ip(a.i.wallet_verify_code_comfirm_title);
      paramView.aeA(this.qHg.getString(a.i.wallet_verify_code_comfirm_text, new Object[] { this.qHg.bWZ() }));
      paramView.nW(true);
      paramView.Is(a.i.wallet_verify_code_comfirm_ok_btn);
      paramView.It(a.i.wallet_verify_code_comfirm_cancel_btn);
      paramView.a(new WalletVerifyCodeUI.5.1(this, i));
      paramView.b(new WalletVerifyCodeUI.5.2(this, i));
      paramView.aoP().show();
      h.nFQ.f(15443, new Object[] { Integer.valueOf(1) });
      WalletVerifyCodeUI.b(this.qHg);
      return;
      if (this.qge.bUR())
      {
        i = 3;
      }
      else
      {
        i = 2;
        continue;
        this.qHg.bXa();
        return;
        label213:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.5
 * JD-Core Version:    0.7.0.1
 */