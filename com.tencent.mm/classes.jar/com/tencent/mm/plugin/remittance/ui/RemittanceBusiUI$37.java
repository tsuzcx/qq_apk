package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.sdk.platformtools.ac;

final class RemittanceBusiUI$37
  implements ar.b.a
{
  RemittanceBusiUI$37(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68044);
    ac.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramBoolean) });
    RemittanceBusiUI.l(this.wPT);
    AppMethodBeat.o(68044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.37
 * JD-Core Version:    0.7.0.1
 */