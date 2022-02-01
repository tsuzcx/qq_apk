package com.tencent.mm.plugin.webview.fts;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

class FTSWebViewLogic$4
  extends IListener<ox>
{
  FTSWebViewLogic$4(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295633);
    this.__eventId = ox.class.getName().hashCode();
    AppMethodBeat.o(295633);
  }
  
  private boolean c(ox paramox)
  {
    AppMethodBeat.i(295636);
    f localf = paramox.hRN.hRG;
    int i;
    if (localf == null)
    {
      i = 0;
      Log.d("MicroMsg.WebSearch.FTSWebViewLogic", "musicPlayerListener type:%s webviewId:%s", new Object[] { Integer.valueOf(i), c.d(this.WAL) });
      if ((localf != null) && (a.e(localf))) {
        switch (paramox.hRN.action)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(295636);
      return false;
      i = localf.oOt;
      break;
      paramox = c.d(this.WAL).iterator();
      while (paramox.hasNext()) {
        k.auP(((Integer)paramox.next()).intValue()).hY(localf.oOv, 0);
      }
      paramox = c.d(this.WAL).iterator();
      while (paramox.hasNext()) {
        k.auP(((Integer)paramox.next()).intValue()).hY(localf.oOv, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.FTSWebViewLogic.4
 * JD-Core Version:    0.7.0.1
 */