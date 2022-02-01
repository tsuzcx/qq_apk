package com.tencent.mm.plugin.offline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;

final class k$5
  implements a
{
  k$5(k paramk)
  {
    AppMethodBeat.i(160815);
    AppMethodBeat.o(160815);
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(182489);
    ae.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      k.dzJ().gT(7, 7);
    }
    AppMethodBeat.o(182489);
  }
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.5
 * JD-Core Version:    0.7.0.1
 */