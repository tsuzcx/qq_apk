package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.np;
import com.tencent.mm.plugin.scanner.f.e.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class e$1
  implements e.a
{
  e$1(e parame) {}
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(51612);
    Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramInt) });
    np localnp = new np();
    localnp.dTL.dTJ = paramInt;
    localnp.dTL.activity = this.CFy.mActivity;
    localnp.dTL.dDX = this.CFy.CFr;
    localnp.dTL.dTM = paramBundle;
    EventCenter.instance.publish(localnp);
    AppMethodBeat.o(51612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e.1
 * JD-Core Version:    0.7.0.1
 */