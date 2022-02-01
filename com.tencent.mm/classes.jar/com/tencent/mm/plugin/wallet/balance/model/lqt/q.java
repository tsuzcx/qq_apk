package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class q
  extends com.tencent.mm.wallet_core.c.a<dbs, CgiLqtPlanIndex>
{
  private static dbs fMR()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)g.aAh().azQ().get(ar.a.Ofs, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (dbs)new dbs().parseFrom((byte[])localObject);
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
  
  public final void b(c.a<dbs> parama)
  {
    AppMethodBeat.i(182497);
    Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((dbs)parama.iLC).pTZ == 0)) {
      try
      {
        parama = new String(((dbs)parama.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.aAh().azQ().set(ar.a.Ofs, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */