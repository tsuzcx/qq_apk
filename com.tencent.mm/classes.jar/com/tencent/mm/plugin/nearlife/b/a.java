package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.cqg;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(cqg paramcqg, final a.a parama)
  {
    AppMethodBeat.i(163196);
    paramcqg = new d(paramcqg);
    parama = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(163195);
        h.aGY().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.GtF) {}
          for (paramAnonymousString = ((bwy)d.c.b(((d)paramAnonymousq).rr.lBS)).TgQ;; paramAnonymousString = ((bwy)d.c.b(((d)paramAnonymousq).rr.lBS)).mVA)
          {
            parama.t(paramAnonymousString, ((bwy)d.c.b(((d)paramAnonymousq).rr.lBS)).TgL);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.t("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    h.aGY().a(603, parama);
    h.aGY().a(paramcqg, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */