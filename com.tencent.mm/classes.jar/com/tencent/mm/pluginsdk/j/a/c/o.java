package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import java.util.Collection;
import java.util.Iterator;

public final class o
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final o Fjo;
  private final com.tencent.mm.sdk.b.c Fjp;
  private final n pdH;
  
  static
  {
    AppMethodBeat.i(152052);
    Fjo = new o();
    AppMethodBeat.o(152052);
  }
  
  public o()
  {
    AppMethodBeat.i(152049);
    this.pdH = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(152047);
        p.agJ();
        AppMethodBeat.o(152047);
      }
    };
    this.Fjp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(152049);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(152050);
    paramc = r.feR().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).feu();
    }
    com.tencent.mm.kernel.g.ajQ().a(this.pdH);
    this.Fjp.alive();
    AppMethodBeat.o(152050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152051);
    com.tencent.mm.kernel.g.ajQ().b(this.pdH);
    this.Fjp.dead();
    Iterator localIterator = r.feR().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(152051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.o
 * JD-Core Version:    0.7.0.1
 */