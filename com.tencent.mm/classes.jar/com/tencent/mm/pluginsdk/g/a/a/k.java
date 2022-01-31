package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.f;
import com.tencent.mm.pluginsdk.g.a.c.f.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k
  extends f<a>
{
  private final f<a>.a rWY = new f.a(this, 0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new u());
  
  static void f(s params)
  {
    new k.a(a.a(params)).run();
  }
  
  final void a(a parama)
  {
    if (Wj(parama.rVT)) {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.rVT });
    }
    for (;;)
    {
      return;
      if (((parama.rVU) && (parama.bHw == parama.rVX) && (parama.rVX >= 0)) || ((!parama.rVU) && (parama.rVV))) {}
      for (int i = 1; i != 0; i = 0)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.rVT });
        super.b(parama);
        return;
      }
    }
  }
  
  protected final f<a>.a clz()
  {
    return this.rWY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.k
 * JD-Core Version:    0.7.0.1
 */