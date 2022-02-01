package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class RemittanceNewBaseUI$3
  implements az.b.a
{
  RemittanceNewBaseUI$3(RemittanceNewBaseUI paramRemittanceNewBaseUI, long paramLong) {}
  
  public final void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68216);
    if (paramBoolean)
    {
      Log.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - this.tYe) + " ms");
      d.aH(paramString, 3);
    }
    for (;;)
    {
      RemittanceNewBaseUI.l(this.IuE);
      AppMethodBeat.o(68216);
      return;
      Log.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.3
 * JD-Core Version:    0.7.0.1
 */