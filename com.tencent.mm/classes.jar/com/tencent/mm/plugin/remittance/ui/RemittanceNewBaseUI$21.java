package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceNewBaseUI$21
  implements c.a
{
  RemittanceNewBaseUI$21(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void Yk(String paramString)
  {
    AppMethodBeat.i(142246);
    ab.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramString });
    this.qqR.qlR = paramString;
    this.qqR.cho();
    AppMethodBeat.o(142246);
  }
  
  public final void onCancel()
  {
    this.qqR.qlR = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.21
 * JD-Core Version:    0.7.0.1
 */