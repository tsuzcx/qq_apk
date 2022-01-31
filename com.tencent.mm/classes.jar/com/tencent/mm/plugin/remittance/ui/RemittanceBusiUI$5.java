package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.model.d;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.ui.MMActivity;

final class RemittanceBusiUI$5
  implements d
{
  RemittanceBusiUI$5(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void a(int paramInt1, int paramInt2, g paramg)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramg.nxZ.ino != 0) {
        com.tencent.mm.ui.base.s.makeText(this.nCA.mController.uMN, paramg.nxZ.inp, 0).show();
      }
      return;
    }
    com.tencent.mm.ui.base.s.makeText(this.nCA.mController.uMN, this.nCA.getString(a.i.wallet_data_err), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.5
 * JD-Core Version:    0.7.0.1
 */