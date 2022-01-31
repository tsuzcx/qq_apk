package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class h$4
  implements Runnable
{
  h$4(h paramh, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(5741);
    if (h.b(this.uPD) != null) {
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(h.b(this.uPD).getCount()) });
    }
    int i;
    for (;;)
    {
      try
      {
        h.b(this.uPD).await();
        i = this.uPp;
        if (h.c(this.uPD) == null) {
          break;
        }
        int j = h.c(this.uPD).cCT;
        i = j;
        if (!h.c(this.uPD).uIW) {
          break;
        }
        i = j;
        if (!h.d(this.uPD)) {
          break;
        }
        ab.w("MicroMsg.WebSearch.WebSearchLogic", "ingore pre get data");
        AppMethodBeat.o(5741);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localInterruptedException, "", new Object[0]);
        continue;
      }
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "count down latch null");
    }
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), this.uPq, h.c(this.uPD) });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(i).a(this.val$data, this.uPr, this.uPq, this.hmS);
    AppMethodBeat.o(5741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.4
 * JD-Core Version:    0.7.0.1
 */