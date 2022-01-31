package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceNewBaseUI$24
  implements DialogInterface.OnClickListener
{
  RemittanceNewBaseUI$24(RemittanceNewBaseUI paramRemittanceNewBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142249);
    ab.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
    paramDialogInterface = new bv();
    paramDialogInterface.cYX = ((int)this.qlb.qjN);
    paramDialogInterface = paramDialogInterface.gR(this.qlb.username);
    paramDialogInterface.cYR = 8L;
    paramDialogInterface.ake();
    AppMethodBeat.o(142249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.24
 * JD-Core Version:    0.7.0.1
 */