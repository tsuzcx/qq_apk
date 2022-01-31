package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceBaseUI$20
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$20(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44845);
    ab.i("MicroMsg.RemittanceBaseUI", "onClick1");
    paramDialogInterface = new bv();
    paramDialogInterface.cYX = ((int)this.qlb.qjN);
    paramDialogInterface = paramDialogInterface.gR(this.qlb.username);
    paramDialogInterface.cYR = 8L;
    paramDialogInterface.ake();
    AppMethodBeat.o(44845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.20
 * JD-Core Version:    0.7.0.1
 */