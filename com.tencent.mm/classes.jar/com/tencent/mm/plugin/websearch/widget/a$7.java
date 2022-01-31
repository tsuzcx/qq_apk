package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.widget.c.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$7
  implements Runnable
{
  a$7(a parama, int paramInt1, int paramInt2, String paramString1, n paramn, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(91399);
    b localb = new b(this.bDS, this.bDT, this.uMe);
    n localn = this.uMf;
    if (localn == null) {
      ab.e("BaseJsapiEvent", "null JSBridgeAccessible ");
    }
    for (boolean bool = false; !bool; bool = localn.at(localb.getName(), localb.dae()))
    {
      ab.i("FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { this.hoG });
      a.c(this.uLR).a(this.uMe, false, "onTap fail: execute js event  " + this.hoG, this.hoG);
      AppMethodBeat.o(91399);
      return;
    }
    a.b(this.uLR, this.uMe);
    com.tencent.mm.ch.a.s(new a.7.1(this));
    AppMethodBeat.o(91399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.7
 * JD-Core Version:    0.7.0.1
 */