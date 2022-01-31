package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.ok.a;
import com.tencent.mm.plugin.remittance.model.u;

final class RemittanceDetailUI$1$1
  implements DialogInterface.OnClickListener
{
  RemittanceDetailUI$1$1(RemittanceDetailUI.1 param1, ok paramok) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44992);
    paramDialogInterface = new u(this.qpZ.cEV.cnJ, this.qpZ.cEV.cyr, this.qpZ.cEV.cEW, "refuse", this.qpZ.cEV.cEX, this.qpZ.cEV.cEY);
    paramDialogInterface.setProcessName("RemittanceProcess");
    this.qqa.qpY.doSceneProgress(paramDialogInterface);
    AppMethodBeat.o(44992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.1.1
 * JD-Core Version:    0.7.0.1
 */