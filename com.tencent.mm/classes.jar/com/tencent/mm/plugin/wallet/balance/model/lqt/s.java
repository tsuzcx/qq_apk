package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;

public final class s
  extends com.tencent.mm.wallet_core.model.a<eds, CgiLqtPlanIndex>
{
  private static eds iet()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)h.baE().ban().get(at.a.acVj, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.b.a.ISO_8859_1);
    try
    {
      localObject = (eds)new eds().parseFrom((byte[])localObject);
      AppMethodBeat.o(68454);
      return localObject;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68454);
    }
    return null;
  }
  
  public final void b(b.a<eds> parama)
  {
    AppMethodBeat.i(182497);
    Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((eds)parama.ott).wuz == 0)) {
      try
      {
        parama = new String(((eds)parama.ott).toByteArray(), org.apache.commons.b.a.ISO_8859_1);
        h.baE().ban().set(at.a.acVj, parama);
        AppMethodBeat.o(182497);
        return;
      }
      catch (IOException parama)
      {
        Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */