package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.mq;

final class RemittanceBusiUI$19
  implements DialogInterface.OnClickListener
{
  RemittanceBusiUI$19(RemittanceBusiUI paramRemittanceBusiUI, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142191);
    RemittanceBusiUI.a(this.qoF, 3, this.qoJ.qji.wpp);
    if (!RemittanceBusiUI.a(this.qoF, this.qoJ))
    {
      if ((RemittanceBusiUI.M(this.qoF)) && (((b)g.E(b.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
      {
        if (RemittanceBusiUI.N(this.qoF) == null) {
          break label102;
        }
        RemittanceBusiUI.N(this.qoF).showSafeProgress();
      }
      for (;;)
      {
        RemittanceBusiUI.b(this.qoF, this.qoJ);
        AppMethodBeat.o(142191);
        return;
        label102:
        RemittanceBusiUI.O(this.qoF);
      }
    }
    RemittanceBusiUI.P(this.qoF);
    AppMethodBeat.o(142191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.19
 * JD-Core Version:    0.7.0.1
 */