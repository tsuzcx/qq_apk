package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class g$2
  implements Runnable
{
  g$2(g paramg, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(5723);
    if (g.a(this.uPo) != null) {
      ab.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(g.a(this.uPo).getCount()) });
    }
    int i;
    for (;;)
    {
      try
      {
        g.a(this.uPo).await();
        i = this.uPp;
        if (g.b(this.uPo) == null) {
          break;
        }
        int j = g.b(this.uPo).cCT;
        i = j;
        if (!g.b(this.uPo).uIW) {
          break;
        }
        i = j;
        if (!g.c(this.uPo)) {
          break;
        }
        ab.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
        AppMethodBeat.o(5723);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
        continue;
      }
      ab.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
    }
    ab.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), this.uPq, g.b(this.uPo) });
    h.KW(i).a(this.val$data, this.uPr, this.uPq, null);
    AppMethodBeat.o(5723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.2
 * JD-Core Version:    0.7.0.1
 */