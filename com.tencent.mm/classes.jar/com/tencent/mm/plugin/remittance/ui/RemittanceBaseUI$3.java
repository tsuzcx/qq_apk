package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceBaseUI$3
  implements View.OnClickListener
{
  RemittanceBaseUI$3(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    c.a(this.nAH, this.nAH.fzn, RemittanceBaseUI.d(this.nAH), RemittanceBaseUI.a(this.nAH));
    if (this.nAH.fzn == 1)
    {
      h.nFQ.f(12689, new Object[] { Integer.valueOf(13), Integer.valueOf(1) });
      return;
    }
    h.nFQ.f(12689, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.3
 * JD-Core Version:    0.7.0.1
 */