package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g$a
  implements Comparable
{
  public a qZK;
  private ThreadPoolExecutor qZX = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
  public g.a.a qZY;
  
  private g$a(g paramg) {}
  
  public final void b(s params)
  {
    if (this.qZY != null) {
      this.qZY.hMo = true;
    }
    this.qZY = new g.a.a(this, (byte)0);
    this.qZY.dZR = params;
    g.a(this.qZU, params);
    this.qZX.execute(this.qZY);
  }
  
  public final int compareTo(Object paramObject)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.a
 * JD-Core Version:    0.7.0.1
 */