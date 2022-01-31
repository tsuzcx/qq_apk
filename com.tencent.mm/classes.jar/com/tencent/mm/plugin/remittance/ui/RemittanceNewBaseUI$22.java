package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceNewBaseUI$22
  implements DialogInterface.OnClickListener
{
  RemittanceNewBaseUI$22(RemittanceNewBaseUI paramRemittanceNewBaseUI, v paramv, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142247);
    ab.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.s(this.qqR) });
    paramDialogInterface = new bv();
    paramDialogInterface.cYX = ((int)this.qlb.qjN);
    paramDialogInterface = paramDialogInterface.gR(this.qlb.username);
    paramDialogInterface.cYR = 9L;
    paramDialogInterface.ake();
    this.qlb.qka = null;
    this.qqR.a(this.qmn, this.val$name, this.qmo, this.qlb);
    AppMethodBeat.o(142247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.22
 * JD-Core Version:    0.7.0.1
 */