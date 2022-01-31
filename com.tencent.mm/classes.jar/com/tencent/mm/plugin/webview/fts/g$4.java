package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class g$4
  implements Runnable
{
  g$4(g paramg, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle) {}
  
  public final void run()
  {
    if (g.b(this.qZU) != null) {
      y.i("MicroMsg.FTS.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(g.b(this.qZU).getCount()) });
    }
    int i;
    for (;;)
    {
      try
      {
        g.b(this.qZU).await();
        i = this.qZH;
        if (g.c(this.qZU) == null) {
          break;
        }
        int j = g.c(this.qZU).bVm;
        i = j;
        if (!g.c(this.qZU).qTO) {
          break;
        }
        i = j;
        if (!g.d(this.qZU)) {
          break;
        }
        y.w("MicroMsg.FTS.WebSearchLogic", "ingore pre get data");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localInterruptedException, "", new Object[0]);
        continue;
      }
      y.i("MicroMsg.FTS.WebSearchLogic", "count down latch null");
    }
    y.i("MicroMsg.FTS.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), this.qZI, g.c(this.qZU) });
    h.Db(i).a(this.val$data, this.qZJ, this.qZI, this.fTr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.4
 * JD-Core Version:    0.7.0.1
 */