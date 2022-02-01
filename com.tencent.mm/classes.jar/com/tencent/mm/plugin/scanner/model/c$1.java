package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

final class c$1
  implements e.a
{
  c$1(c paramc) {}
  
  public final void s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(51612);
    ac.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramInt) });
    mo localmo = new mo();
    localmo.dpd.dpb = paramInt;
    localmo.dpd.activity = this.wYT.mActivity;
    localmo.dpd.dam = this.wYT.wYM;
    localmo.dpd.dpe = paramBundle;
    a.GpY.l(localmo);
    AppMethodBeat.o(51612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c.1
 * JD-Core Version:    0.7.0.1
 */