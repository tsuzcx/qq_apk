package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.boz;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(boz paramboz, final a.a parama)
  {
    AppMethodBeat.i(163196);
    paramboz = new d(paramboz);
    parama = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163195);
        com.tencent.mm.kernel.g.agi().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.vkr) {}
          for (paramAnonymousString = ((ayw)((d)paramAnonymousn).rr.hvs.hvw).EQw;; paramAnonymousString = ((ayw)((d)paramAnonymousn).rr.hvs.hvw).iJV)
          {
            parama.p(paramAnonymousString, ((ayw)((d)paramAnonymousn).rr.hvs.hvw).EQr);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.p("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    com.tencent.mm.kernel.g.agi().a(603, parama);
    com.tencent.mm.kernel.g.agi().a(paramboz, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */