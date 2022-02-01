package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bug;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(bug parambug, final a.a parama)
  {
    AppMethodBeat.i(163196);
    parambug = new d(parambug);
    parama = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163195);
        g.ajj().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.wFs) {}
          for (paramAnonymousString = ((bdq)((d)paramAnonymousn).rr.hQE.hQJ).GTn;; paramAnonymousString = ((bdq)((d)paramAnonymousn).rr.hQE.hQJ).jfX)
          {
            parama.s(paramAnonymousString, ((bdq)((d)paramAnonymousn).rr.hQE.hQJ).GTi);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.s("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    g.ajj().a(603, parama);
    g.ajj().a(parambug, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */