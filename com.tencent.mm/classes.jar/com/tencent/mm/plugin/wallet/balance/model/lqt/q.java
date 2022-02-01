package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;

public final class q
  extends com.tencent.mm.wallet_core.c.a<cli, CgiLqtPlanIndex>
{
  private static cli eFJ()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)g.ajR().ajA().get(am.a.IWZ, "");
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cli)new cli().parseFrom((byte[])localObject);
      AppMethodBeat.o(68454);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68454);
    }
    return null;
  }
  
  public final void c(a.a<cli> parama)
  {
    AppMethodBeat.i(182497);
    ae.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cli)parama.hQv).oGt == 0)) {
      try
      {
        parama = new String(((cli)parama.hQv).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.ajR().ajA().set(am.a.IWZ, parama);
        AppMethodBeat.o(182497);
        return;
      }
      catch (IOException parama)
      {
        ae.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */