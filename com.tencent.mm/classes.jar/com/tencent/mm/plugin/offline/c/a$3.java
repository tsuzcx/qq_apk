package com.tencent.mm.plugin.offline.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class a$3
  implements bk.a
{
  public final void a(e parame)
  {
    AppMethodBeat.i(43648);
    if ((parame == null) || (parame.adI() == null))
    {
      AppMethodBeat.o(43648);
      return;
    }
    if (a.access$000() != null) {
      parame.adI().o("offline_token", a.access$000().getBytes());
    }
    if (a.poc != null) {
      parame.adI().o("offline_token_V2", a.poc.getBytes());
    }
    if (a.pof != null) {
      parame.adI().o("offline_key_list", a.pof.getBytes());
    }
    AppMethodBeat.o(43648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.3
 * JD-Core Version:    0.7.0.1
 */