package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceBaseUI$10
  implements View.OnClickListener
{
  RemittanceBaseUI$10(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(View paramView)
  {
    this.nAH.a(this.nAI.bOT, this.nAH.djD, this.nAH.nAo, this.nAI);
    if (this.nAH.fzn == 1)
    {
      h.nFQ.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
      return;
    }
    h.nFQ.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.10
 * JD-Core Version:    0.7.0.1
 */