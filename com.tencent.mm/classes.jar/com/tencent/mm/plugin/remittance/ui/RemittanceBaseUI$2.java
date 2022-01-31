package com.tencent.mm.plugin.remittance.ui;

import android.widget.ScrollView;
import com.tencent.mm.wallet_core.ui.a;

final class RemittanceBaseUI$2
  implements a
{
  RemittanceBaseUI$2(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void gK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RemittanceBaseUI.a(this.nAH, this.nAH.lls, this.nAH.frP);
      return;
    }
    this.nAH.lls.scrollTo(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.2
 * JD-Core Version:    0.7.0.1
 */