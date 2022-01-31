package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiUI$16
  implements DialogInterface.OnClickListener
{
  RemittanceBusiUI$16(RemittanceBusiUI paramRemittanceBusiUI, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { this.nCE.nyh.sFb.iHx });
    e.l(this.nCA.mController.uMN, this.nCE.nyh.sFb.iHx, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.16
 * JD-Core Version:    0.7.0.1
 */