package com.tencent.mm.plugin.webview.fts;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class h$4
  implements Runnable
{
  public h$4(h paramh, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(77954);
    b.g localg = com.tencent.mm.plugin.webview.modeltools.g.eBX().UE(this.fsL);
    if ((localg == null) || (localg.isExpired()))
    {
      com.tencent.e.h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188281);
          Object localObject = new HashMap();
          ((Map)localObject).put("scene", Integer.valueOf(h.4.this.fsL));
          ((Map)localObject).put("statSessionId", h.4.this.jMD);
          localObject = new d((Map)localObject, h.4.this.fsL, 1);
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          AppMethodBeat.o(188281);
        }
      });
      AppMethodBeat.o(77954);
      return;
    }
    ac.i("MicroMsg.WebSearch.WebSearchLogic", "guide data not expired %d %s", new Object[] { Integer.valueOf(this.fsL), this.jMD });
    AppMethodBeat.o(77954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.4
 * JD-Core Version:    0.7.0.1
 */