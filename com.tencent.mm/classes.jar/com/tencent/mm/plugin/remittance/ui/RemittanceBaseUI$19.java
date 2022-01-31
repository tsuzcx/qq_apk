package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceBaseUI$19
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$19(RemittanceBaseUI paramRemittanceBaseUI, v paramv, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142152);
    ab.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.k(this.qmk) });
    paramDialogInterface = new bv();
    paramDialogInterface.cYX = ((int)this.qlb.qjN);
    paramDialogInterface = paramDialogInterface.gR(this.qlb.username);
    paramDialogInterface.cYR = 9L;
    paramDialogInterface.ake();
    this.qlb.qka = null;
    this.qmk.a(this.qmn, this.val$name, this.qmo, this.qlb);
    AppMethodBeat.o(142152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.19
 * JD-Core Version:    0.7.0.1
 */