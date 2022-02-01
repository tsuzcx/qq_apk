package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.bld;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(bld parambld, final a.a parama)
  {
    AppMethodBeat.i(163196);
    parambld = new d(parambld);
    parama = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163195);
        com.tencent.mm.kernel.g.aeS().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.ubt) {}
          for (paramAnonymousString = ((avq)((d)paramAnonymousn).rr.gUT.gUX).Dvn;; paramAnonymousString = ((avq)((d)paramAnonymousn).rr.gUT.gUX).ijO)
          {
            parama.r(paramAnonymousString, ((avq)((d)paramAnonymousn).rr.gUT.gUX).Dvi);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.r("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    com.tencent.mm.kernel.g.aeS().a(603, parama);
    com.tencent.mm.kernel.g.aeS().a(parambld, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */