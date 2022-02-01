package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import java.util.Iterator;
import java.util.Set;

final class c$2
  extends com.tencent.mm.sdk.b.c<mg>
{
  c$2(c paramc)
  {
    AppMethodBeat.i(160414);
    this.__eventId = mg.class.getName().hashCode();
    AppMethodBeat.o(160414);
  }
  
  private boolean a(mg parammg)
  {
    AppMethodBeat.i(77887);
    com.tencent.mm.ay.f localf = parammg.dAP.dAJ;
    if ((localf != null) && (a.e(localf))) {
      switch (parammg.dAP.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77887);
      return false;
      parammg = this.EbY.EbO.iterator();
      while (parammg.hasNext()) {
        g.Yt(((Integer)parammg.next()).intValue()).fT(localf.ijZ, 0);
      }
      parammg = this.EbY.EbO.iterator();
      while (parammg.hasNext()) {
        g.Yt(((Integer)parammg.next()).intValue()).fT(localf.ijZ, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.2
 * JD-Core Version:    0.7.0.1
 */