package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.event.IListener;
import java.util.Collection;
import java.util.Iterator;

public final class o
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final o Kah;
  private final IListener Kai;
  private final com.tencent.mm.network.p qsH;
  
  static
  {
    AppMethodBeat.i(152052);
    Kah = new o();
    AppMethodBeat.o(152052);
  }
  
  public o()
  {
    AppMethodBeat.i(152049);
    this.qsH = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(152047);
        p.awI();
        AppMethodBeat.o(152047);
      }
    };
    this.Kai = new IListener() {};
    AppMethodBeat.o(152049);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(152050);
    paramc = r.gob().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).gnE();
    }
    com.tencent.mm.kernel.g.aAg().a(this.qsH);
    this.Kai.alive();
    AppMethodBeat.o(152050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152051);
    com.tencent.mm.kernel.g.aAg().b(this.qsH);
    this.Kai.dead();
    Iterator localIterator = r.gob().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(152051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.o
 * JD-Core Version:    0.7.0.1
 */