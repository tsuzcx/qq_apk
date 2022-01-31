package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceBusiUI$29
  implements ao.b.a
{
  RemittanceBusiUI$29(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44919);
    ab.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramBoolean) });
    RemittanceBusiUI.j(this.qoF);
    AppMethodBeat.o(44919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.29
 * JD-Core Version:    0.7.0.1
 */