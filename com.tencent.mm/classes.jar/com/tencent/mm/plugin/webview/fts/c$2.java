package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import java.util.Iterator;
import java.util.Set;

final class c$2
  extends com.tencent.mm.sdk.b.c<mf>
{
  c$2(c paramc)
  {
    AppMethodBeat.i(160414);
    this.__eventId = mf.class.getName().hashCode();
    AppMethodBeat.o(160414);
  }
  
  private boolean a(mf parammf)
  {
    AppMethodBeat.i(77887);
    com.tencent.mm.az.f localf = parammf.dzK.dzE;
    if ((localf != null) && (a.e(localf))) {
      switch (parammf.dzK.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77887);
      return false;
      parammf = this.DKa.DJQ.iterator();
      while (parammf.hasNext()) {
        g.XN(((Integer)parammf.next()).intValue()).fI(localf.ihg, 0);
      }
      parammf = this.DKa.DJQ.iterator();
      while (parammf.hasNext()) {
        g.XN(((Integer)parammf.next()).intValue()).fI(localf.ihg, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.2
 * JD-Core Version:    0.7.0.1
 */