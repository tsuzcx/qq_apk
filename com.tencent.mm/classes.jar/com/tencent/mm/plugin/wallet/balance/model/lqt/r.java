package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class r
  extends com.tencent.mm.wallet_core.c.a<ddt, k>
{
  private ddt fMS()
  {
    AppMethodBeat.i(68457);
    if (((k)this.iLD).scene == 2)
    {
      AppMethodBeat.o(68457);
      return null;
    }
    Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Ofu, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68457);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (ddt)new ddt().parseFrom((byte[])localObject);
      AppMethodBeat.o(68457);
      return localObject;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68457);
    }
    return null;
  }
  
  public final void b(c.a<ddt> parama)
  {
    AppMethodBeat.i(182498);
    Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (((k)this.iLD).scene == 2)
    {
      AppMethodBeat.o(182498);
      return;
    }
    if ((parama.errType == 0) && (parama.errCode == 0) && (((ddt)parama.iLC).pTZ == 0)) {
      try
      {
        parama = new String(((ddt)parama.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.Ofu, parama);
        AppMethodBeat.o(182498);
        return;
      }
      catch (IOException parama)
      {
        Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.r
 * JD-Core Version:    0.7.0.1
 */