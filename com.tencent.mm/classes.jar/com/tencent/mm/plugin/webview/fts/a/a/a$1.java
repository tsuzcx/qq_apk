package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.mm.h.b.a.bb;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Iterator;
import java.util.List;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    y.i("WidgetPkgCoverageReport", "begin check");
    b.caF();
    Object localObject1 = a.b.dHs;
    localObject1 = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100429");
    if ((localObject1 == null) || (!((c)localObject1).isValid())) {}
    for (boolean bool = false;; bool = b.a((c)localObject1))
    {
      localObject2 = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.g.class)).Jo();
      localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        w localw = (w)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(":").append(localw.bOL).append("_").append(localw.version).append("_").append(localw.bIW);
      }
    }
    Object localObject2 = new bb();
    if (bool) {}
    for (long l = 1L;; l = 0L)
    {
      ((bb)localObject2).cqP = l;
      ((bb)localObject2).cqQ = ((StringBuilder)localObject1).toString();
      ((bb)localObject2).QX();
      y.i("WidgetPkgCoverageReport", "end check");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */