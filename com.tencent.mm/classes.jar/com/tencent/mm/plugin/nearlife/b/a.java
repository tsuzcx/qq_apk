package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.chk;
import java.util.Collections;

public final class a
  implements com.tencent.mm.pluginsdk.location.a
{
  public final void a(chk paramchk, final a.a parama)
  {
    AppMethodBeat.i(163196);
    paramchk = new d(paramchk);
    parama = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(163195);
        g.azz().b(603, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (this.AAD) {}
          for (paramAnonymousString = ((bpe)((d)paramAnonymousq).rr.iLL.iLR).LXz;; paramAnonymousString = ((bpe)((d)paramAnonymousq).rr.iLL.iLR).kea)
          {
            parama.s(paramAnonymousString, ((bpe)((d)paramAnonymousq).rr.iLL.iLR).LXu);
            AppMethodBeat.o(163195);
            return;
          }
        }
        parama.s("", Collections.EMPTY_LIST);
        AppMethodBeat.o(163195);
      }
    };
    g.azz().a(603, parama);
    g.azz().a(paramchk, 0);
    AppMethodBeat.o(163196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */