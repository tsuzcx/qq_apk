package com.tencent.mm.plugin.webview.fts;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class i$4
  implements Runnable
{
  public i$4(i parami, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(77954);
    c.g localg = com.tencent.mm.plugin.webview.modeltools.g.eUD().Xd(this.fNp);
    if ((localg == null) || (localg.isExpired()))
    {
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197991);
          Object localObject = new HashMap();
          ((Map)localObject).put("scene", Integer.valueOf(i.4.this.fNp));
          ((Map)localObject).put("statSessionId", i.4.this.kke);
          localObject = new e((Map)localObject, i.4.this.fNp, 1);
          com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
          AppMethodBeat.o(197991);
        }
      });
      AppMethodBeat.o(77954);
      return;
    }
    ae.i("MicroMsg.WebSearch.WebSearchLogic", "guide data not expired %d %s", new Object[] { Integer.valueOf(this.fNp), this.kke });
    AppMethodBeat.o(77954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i.4
 * JD-Core Version:    0.7.0.1
 */