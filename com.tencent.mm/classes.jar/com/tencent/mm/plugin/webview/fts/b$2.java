package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.b.c;
import java.util.Iterator;
import java.util.Set;

final class b$2
  extends c<lw>
{
  b$2(b paramb)
  {
    AppMethodBeat.i(160414);
    this.__eventId = lw.class.getName().hashCode();
    AppMethodBeat.o(160414);
  }
  
  private boolean a(lw paramlw)
  {
    AppMethodBeat.i(77887);
    com.tencent.mm.ay.f localf = paramlw.dnW.dnQ;
    if ((localf != null) && (a.e(localf))) {
      switch (paramlw.dnW.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77887);
      return false;
      paramlw = this.CgT.CgJ.iterator();
      while (paramlw.hasNext()) {
        g.VW(((Integer)paramlw.next()).intValue()).fl(localf.hNS, 0);
      }
      paramlw = this.CgT.CgJ.iterator();
      while (paramlw.hasNext()) {
        g.VW(((Integer)paramlw.next()).intValue()).fl(localf.hNS, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.2
 * JD-Core Version:    0.7.0.1
 */