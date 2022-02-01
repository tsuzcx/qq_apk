package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class r
  extends com.tencent.mm.wallet_core.c.a<cmg, k>
{
  private cmg eFK()
  {
    AppMethodBeat.i(68457);
    if (((k)this.hQw).scene == 2)
    {
      AppMethodBeat.o(68457);
      return null;
    }
    Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXb, "");
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68457);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cmg)new cmg().parseFrom((byte[])localObject);
      AppMethodBeat.o(68457);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68457);
    }
    return null;
  }
  
  public final void c(a.a<cmg> parama)
  {
    AppMethodBeat.i(182498);
    ae.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (((k)this.hQw).scene == 2)
    {
      AppMethodBeat.o(182498);
      return;
    }
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cmg)parama.hQv).oGt == 0)) {
      try
      {
        parama = new String(((cmg)parama.hQv).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXb, parama);
        AppMethodBeat.o(182498);
        return;
      }
      catch (IOException parama)
      {
        ae.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.r
 * JD-Core Version:    0.7.0.1
 */