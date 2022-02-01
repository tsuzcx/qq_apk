package com.tencent.mm.pluginsdk.h.a.c;

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
  public static final o DlR;
  private final com.tencent.mm.sdk.b.c DlS;
  private final n otI;
  
  static
  {
    AppMethodBeat.i(152052);
    DlR = new o();
    AppMethodBeat.o(152052);
  }
  
  public o()
  {
    AppMethodBeat.i(152049);
    this.otI = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(152047);
        p.adP();
        AppMethodBeat.o(152047);
      }
    };
    this.DlS = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(152049);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(152050);
    paramc = r.eMg().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).eLJ();
    }
    com.tencent.mm.kernel.g.agQ().a(this.otI);
    this.DlS.alive();
    AppMethodBeat.o(152050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152051);
    com.tencent.mm.kernel.g.agQ().b(this.otI);
    this.DlS.dead();
    Iterator localIterator = r.eMg().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(152051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.o
 * JD-Core Version:    0.7.0.1
 */