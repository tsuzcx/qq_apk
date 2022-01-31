package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceBaseUI$18
  implements c.a
{
  RemittanceBaseUI$18(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void Yk(String paramString)
  {
    AppMethodBeat.i(142151);
    ab.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramString });
    this.qmk.qlR = paramString;
    this.qmk.cho();
    AppMethodBeat.o(142151);
  }
  
  public final void onCancel()
  {
    this.qmk.qlR = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.18
 * JD-Core Version:    0.7.0.1
 */