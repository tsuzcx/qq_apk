package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.event.IListener;
import java.util.Iterator;
import java.util.Set;

final class c$4
  extends IListener<mx>
{
  c$4(c paramc)
  {
    AppMethodBeat.i(210820);
    this.__eventId = mx.class.getName().hashCode();
    AppMethodBeat.o(210820);
  }
  
  private boolean b(mx parammx)
  {
    AppMethodBeat.i(210821);
    com.tencent.mm.ay.f localf = parammx.dSE.dSy;
    if ((localf != null) && (a.e(localf))) {
      switch (parammx.dSE.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(210821);
      return false;
      parammx = this.IOi.INY.iterator();
      while (parammx.hasNext()) {
        g.ahd(((Integer)parammx.next()).intValue()).gq(localf.jeV, 0);
      }
      parammx = this.IOi.INY.iterator();
      while (parammx.hasNext()) {
        g.ahd(((Integer)parammx.next()).intValue()).gq(localf.jeV, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.4
 * JD-Core Version:    0.7.0.1
 */