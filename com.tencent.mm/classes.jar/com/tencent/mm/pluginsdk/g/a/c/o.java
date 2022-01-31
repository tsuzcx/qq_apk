package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import java.util.Collection;
import java.util.Iterator;

public final class o
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final o rXK = new o();
  private final n iFb = new o.1(this);
  private final com.tencent.mm.sdk.b.c rXL = new o.2(this);
  
  public final void onAccountInitialized(e.c paramc)
  {
    paramc = r.clM().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).ccB();
    }
    com.tencent.mm.kernel.g.DO().a(this.iFb);
    this.rXL.cqo();
  }
  
  public final void onAccountRelease()
  {
    com.tencent.mm.kernel.g.DO().b(this.iFb);
    this.rXL.dead();
    Iterator localIterator = r.clM().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.o
 * JD-Core Version:    0.7.0.1
 */