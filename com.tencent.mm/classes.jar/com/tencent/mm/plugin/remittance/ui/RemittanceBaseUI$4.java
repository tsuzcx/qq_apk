package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBaseUI$4
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$4(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { this.nAI.bZo.iHx });
    e.l(this.nAH.mController.uMN, this.nAI.bZo.iHx, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.4
 * JD-Core Version:    0.7.0.1
 */