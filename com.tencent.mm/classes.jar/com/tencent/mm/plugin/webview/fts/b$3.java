package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import java.util.Iterator;
import java.util.Set;

final class b$3
  extends c<ki>
{
  b$3(b paramb)
  {
    AppMethodBeat.i(5675);
    this.__eventId = ki.class.getName().hashCode();
    AppMethodBeat.o(5675);
  }
  
  private boolean a(ki paramki)
  {
    AppMethodBeat.i(5676);
    e locale = paramki.cAc.czW;
    if ((locale != null) && (a.d(locale))) {
      switch (paramki.cAc.action)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5676);
      return false;
      paramki = this.uOI.uOx.iterator();
      while (paramki.hasNext()) {
        h.KW(((Integer)paramki.next()).intValue()).ec(locale.fKj, 0);
      }
      paramki = this.uOI.uOx.iterator();
      while (paramki.hasNext()) {
        h.KW(((Integer)paramki.next()).intValue()).ec(locale.fKj, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.3
 * JD-Core Version:    0.7.0.1
 */