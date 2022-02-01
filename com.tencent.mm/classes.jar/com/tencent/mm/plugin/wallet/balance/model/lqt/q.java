package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;

public final class q
  extends com.tencent.mm.wallet_core.c.a<caq, CgiLqtPlanIndex>
{
  private static caq dYG()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)g.afB().afk().get(ae.a.Fso, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (caq)new caq().parseFrom((byte[])localObject);
      AppMethodBeat.o(68454);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68454);
    }
    return null;
  }
  
  public final void c(c.a<caq> parama)
  {
    AppMethodBeat.i(182497);
    ad.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((caq)parama.gUK).ntx == 0)) {
      try
      {
        parama = new String(((caq)parama.gUK).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.afB().afk().set(ae.a.Fso, parama);
        AppMethodBeat.o(182497);
        return;
      }
      catch (IOException parama)
      {
        ad.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */