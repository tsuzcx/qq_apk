package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.dha;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(dha paramdha, final a.a parama)
  {
    AppMethodBeat.i(163196);
    paramdha = new d(paramdha);
    parama = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(163195);
        com.tencent.mm.kernel.h.aZW().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.MpF) {}
          for (paramAnonymousString = ((cmb)c.c.b(((d)paramAnonymousp).rr.otC)).aaug;; paramAnonymousString = ((cmb)c.c.b(((d)paramAnonymousp).rr.otC)).pSh)
          {
            parama.onGetLbsLifes(paramAnonymousString, ((cmb)c.c.b(((d)paramAnonymousp).rr.otC)).aaub);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.onGetLbsLifes("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    com.tencent.mm.kernel.h.aZW().a(603, parama);
    com.tencent.mm.kernel.h.aZW().a(paramdha, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */