package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.l;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.event.IListener;
import java.util.Collection;
import java.util.Iterator;

public final class n
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final n RaK;
  private final IListener RaL;
  private final p tRt;
  
  static
  {
    AppMethodBeat.i(152052);
    RaK = new n();
    AppMethodBeat.o(152052);
  }
  
  public n()
  {
    AppMethodBeat.i(152049);
    this.tRt = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(152047);
        o.dwn();
        AppMethodBeat.o(152047);
      }
    };
    this.RaL = new IListener() {};
    AppMethodBeat.o(152049);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(152050);
    paramc = q.hiL().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).hik();
    }
    h.aHF().a(this.tRt);
    this.RaL.alive();
    AppMethodBeat.o(152050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152051);
    h.aHF().b(this.tRt);
    this.RaL.dead();
    Iterator localIterator = q.hiL().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(152051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.n
 * JD-Core Version:    0.7.0.1
 */