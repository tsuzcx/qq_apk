package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;

public final class q
  extends com.tencent.mm.wallet_core.c.a<cko, CgiLqtPlanIndex>
{
  private static cko eCb()
  {
    AppMethodBeat.i(68454);
    Object localObject = (String)g.ajC().ajl().get(al.a.ICz, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68454);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cko)new cko().parseFrom((byte[])localObject);
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
  
  public final void c(a.a<cko> parama)
  {
    AppMethodBeat.i(182497);
    ad.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cko)parama.hNC).ozR == 0)) {
      try
      {
        parama = new String(((cko)parama.hNC).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.ajC().ajl().set(al.a.ICz, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */