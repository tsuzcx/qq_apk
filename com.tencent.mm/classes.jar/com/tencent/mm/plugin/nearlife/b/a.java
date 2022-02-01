package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.btm;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(btm parambtm, final a.a parama)
  {
    AppMethodBeat.i(163196);
    parambtm = new d(parambtm);
    parama = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163195);
        g.aiU().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.wpJ) {}
          for (paramAnonymousString = ((bda)((d)paramAnonymousn).rr.hNL.hNQ).GzN;; paramAnonymousString = ((bda)((d)paramAnonymousn).rr.hNL.hNQ).jde)
          {
            parama.r(paramAnonymousString, ((bda)((d)paramAnonymousn).rr.hNL.hNQ).GzI);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.r("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    g.aiU().a(603, parama);
    g.aiU().a(parambtm, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */