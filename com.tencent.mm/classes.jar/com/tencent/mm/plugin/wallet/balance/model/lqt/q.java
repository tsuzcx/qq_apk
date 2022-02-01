package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;

public final class q
  extends com.tencent.mm.wallet_core.c.a<cfp, CgiLqtPlanIndex>
{
  private static cfp eoc()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)g.agR().agA().get(ah.a.GQf, "");
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cfp)new cfp().parseFrom((byte[])localObject);
      AppMethodBeat.o(68454);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68454);
    }
    return null;
  }
  
  public final void c(c.a<cfp> parama)
  {
    AppMethodBeat.i(182497);
    ac.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cfp)parama.hvj).nWx == 0)) {
      try
      {
        parama = new String(((cfp)parama.hvj).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.agR().agA().set(ah.a.GQf, parama);
        AppMethodBeat.o(182497);
        return;
      }
      catch (IOException parama)
      {
        ac.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */