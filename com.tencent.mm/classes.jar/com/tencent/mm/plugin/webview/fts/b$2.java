package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.b.c;
import java.util.Iterator;
import java.util.Set;

final class b$2
  extends c<ln>
{
  b$2(b paramb)
  {
    AppMethodBeat.i(160414);
    this.__eventId = ln.class.getName().hashCode();
    AppMethodBeat.o(160414);
  }
  
  private boolean a(ln paramln)
  {
    AppMethodBeat.i(77887);
    com.tencent.mm.az.f localf = paramln.dql.dqf;
    if ((localf != null) && (a.e(localf))) {
      switch (paramln.dql.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77887);
      return false;
      paramln = this.AOC.AOr.iterator();
      while (paramln.hasNext()) {
        g.TO(((Integer)paramln.next()).intValue()).fd(localf.hnp, 0);
      }
      paramln = this.AOC.AOr.iterator();
      while (paramln.hasNext()) {
        g.TO(((Integer)paramln.next()).intValue()).fd(localf.hnp, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.2
 * JD-Core Version:    0.7.0.1
 */