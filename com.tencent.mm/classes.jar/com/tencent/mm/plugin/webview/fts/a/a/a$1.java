package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Iterator;
import java.util.List;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5763);
    ab.i("WidgetPkgCoverageReport", "begin check");
    b.daE();
    Object localObject1 = a.b.eEW;
    localObject1 = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100429");
    if ((localObject1 == null) || (!((c)localObject1).isValid())) {}
    for (boolean bool = false;; bool = b.a((c)localObject1))
    {
      localObject2 = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.g.class)).acm();
      localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        x localx = (x)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(":").append(localx.cwc).append("_").append(localx.version).append("_").append(localx.cqq);
      }
    }
    Object localObject2 = new dk();
    if (bool) {}
    for (long l = 1L;; l = 0L)
    {
      ((dk)localObject2).dfn = l;
      ((dk)localObject2).iQ(((StringBuilder)localObject1).toString()).ake();
      ab.i("WidgetPkgCoverageReport", "end check");
      AppMethodBeat.o(5763);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */