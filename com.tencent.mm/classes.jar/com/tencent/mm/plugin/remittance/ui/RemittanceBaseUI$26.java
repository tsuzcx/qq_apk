package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class RemittanceBaseUI$26
  implements az.b.a
{
  RemittanceBaseUI$26(RemittanceBaseUI paramRemittanceBaseUI, long paramLong) {}
  
  public final void getContactCallBack(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(67981);
    if (paramBoolean)
    {
      Log.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - this.xbx) + " ms");
      d.aS(paramString, 3);
    }
    for (;;)
    {
      RemittanceBaseUI.e(this.OmE);
      AppMethodBeat.o(67981);
      return;
      Log.w("MicroMsg.RemittanceBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.26
 * JD-Core Version:    0.7.0.1
 */