package com.tencent.mm.plugin.webview.fts;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class i$4
  implements Runnable
{
  public i$4(i parami, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(77954);
    c.g localg = com.tencent.mm.plugin.webview.modeltools.g.eQR().Ww(this.fLl);
    if ((localg == null) || (localg.isExpired()))
    {
      h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207815);
          Object localObject = new HashMap();
          ((Map)localObject).put("scene", Integer.valueOf(i.4.this.fLl));
          ((Map)localObject).put("statSessionId", i.4.this.kgO);
          localObject = new e((Map)localObject, i.4.this.fLl, 1);
          com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
          AppMethodBeat.o(207815);
        }
      });
      AppMethodBeat.o(77954);
      return;
    }
    ad.i("MicroMsg.WebSearch.WebSearchLogic", "guide data not expired %d %s", new Object[] { Integer.valueOf(this.fLl), this.kgO });
    AppMethodBeat.o(77954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i.4
 * JD-Core Version:    0.7.0.1
 */