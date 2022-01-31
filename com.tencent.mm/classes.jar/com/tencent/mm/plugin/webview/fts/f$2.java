package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class f$2
  implements Runnable
{
  f$2(f paramf, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    if (f.a(this.qZG) != null) {
      y.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(f.a(this.qZG).getCount()) });
    }
    int i;
    for (;;)
    {
      try
      {
        f.a(this.qZG).await();
        i = this.qZH;
        if (f.b(this.qZG) == null) {
          break;
        }
        int j = f.b(this.qZG).bVm;
        i = j;
        if (!f.b(this.qZG).qTO) {
          break;
        }
        i = j;
        if (!f.c(this.qZG)) {
          break;
        }
        y.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
        continue;
      }
      y.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
    }
    y.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), this.qZI, f.b(this.qZG) });
    h.Db(i).a(this.val$data, this.qZJ, this.qZI, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f.2
 * JD-Core Version:    0.7.0.1
 */