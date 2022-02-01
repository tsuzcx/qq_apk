package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$1
  implements bv.a
{
  public a$1(a parama, String paramString, int paramInt) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(73758);
    h.aGY().a(1, "", 0, false);
    Log.appenderFlush();
    h.aGY().a(2, this.jwD, this.mvb, h.aHB());
    AppMethodBeat.o(73758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a.1
 * JD-Core Version:    0.7.0.1
 */