package com.tencent.mm.sdk.b.b;

import com.tencent.mm.sdk.b.a.b;
import com.tencent.mm.sdk.b.c.c;
import com.tencent.mm.sdk.platformtools.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
  implements a
{
  private a abp;
  
  public g(b paramb, d paramd)
  {
    h localh = new h(this, (byte)0);
    int j = Runtime.getRuntime().availableProcessors() * 6;
    if (j > 42) {}
    for (;;)
    {
      LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(i * 2);
      f.c("MicroMsg.ThreadPoolExecutorProxy", "isHandlerThreadPool:%s coreSize:%s", new Object[] { Boolean.TRUE, Integer.valueOf(i) });
      this.abp = new b.1(i, Math.round(0.8F * i), localLinkedBlockingQueue, c.abw, localh, paramd, paramb);
      return;
      if (j < 28) {
        i = 28;
      } else {
        i = j;
      }
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.abp.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b.g
 * JD-Core Version:    0.7.0.1
 */