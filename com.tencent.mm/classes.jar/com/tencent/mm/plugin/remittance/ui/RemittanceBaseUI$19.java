package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

final class RemittanceBaseUI$19
  implements View.OnClickListener
{
  RemittanceBaseUI$19(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    this.nAH.VH();
    h.nFQ.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
    String str;
    if ((this.nAH.fzn == 1) || (this.nAH.fzn == 6))
    {
      paramView = this.nAH.getString(a.i.remittance_add_f2f_desc_link);
      str = this.nAH.getString(a.i.remittance_desc_max_words_count_tip);
      h.nFQ.f(14074, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this.nAH, paramView, this.nAH.dkv, str, 20, new RemittanceBaseUI.19.1(this), new RemittanceBaseUI.19.2(this));
      return;
      paramView = this.nAH.getString(a.i.remittance_add_desc_link);
      str = this.nAH.getString(a.i.remittance_busi_desc_max_words_count_tip);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.19
 * JD-Core Version:    0.7.0.1
 */