package com.tencent.mm.plugin.offline.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements bk.a
{
  public final void a(e parame)
  {
    AppMethodBeat.i(43649);
    if ((parame == null) || (parame.adI() == null))
    {
      ab.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
      AppMethodBeat.o(43649);
      return;
    }
    byte[] arrayOfByte = parame.adI().rm("offline_token");
    if (arrayOfByte != null) {
      a.access$002(new String(arrayOfByte));
    }
    arrayOfByte = parame.adI().rm("offline_token_V2");
    if (arrayOfByte != null) {
      a.poc = new String(arrayOfByte);
    }
    parame = parame.adI().rm("offline_key_list");
    if (parame != null) {
      a.pof = new String(parame);
    }
    AppMethodBeat.o(43649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.4
 * JD-Core Version:    0.7.0.1
 */