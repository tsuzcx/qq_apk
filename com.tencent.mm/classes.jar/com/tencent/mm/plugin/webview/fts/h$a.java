package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h$a
  implements Comparable
{
  private ThreadPoolExecutor cfY;
  public h.a.a uPG;
  public a uPs;
  
  private h$a(h paramh)
  {
    AppMethodBeat.i(5744);
    this.cfY = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
    AppMethodBeat.o(5744);
  }
  
  public final void b(s params)
  {
    AppMethodBeat.i(5745);
    if (this.uPG != null) {
      this.uPG.jFQ = true;
    }
    this.uPG = new h.a.a(this, (byte)0);
    this.uPG.fpY = params;
    h.a(this.uPD, params);
    this.cfY.execute(this.uPG);
    AppMethodBeat.o(5745);
  }
  
  public final int compareTo(Object paramObject)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.a
 * JD-Core Version:    0.7.0.1
 */