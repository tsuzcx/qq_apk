package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import java.util.Collection;
import java.util.Iterator;

public final class o
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final o vOB;
  private final n kKC;
  private final com.tencent.mm.sdk.b.c vOC;
  
  static
  {
    AppMethodBeat.i(79609);
    vOB = new o();
    AppMethodBeat.o(79609);
  }
  
  public o()
  {
    AppMethodBeat.i(79606);
    this.kKC = new o.1(this);
    this.vOC = new o.2(this);
    AppMethodBeat.o(79606);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(79607);
    paramc = r.dmA().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).dmd();
    }
    com.tencent.mm.kernel.g.RK().a(this.kKC);
    this.vOC.alive();
    AppMethodBeat.o(79607);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(79608);
    com.tencent.mm.kernel.g.RK().b(this.kKC);
    this.vOC.dead();
    Iterator localIterator = r.dmA().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(79608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.o
 * JD-Core Version:    0.7.0.1
 */