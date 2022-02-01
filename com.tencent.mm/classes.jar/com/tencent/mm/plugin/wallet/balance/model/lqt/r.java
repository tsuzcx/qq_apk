package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class r
  extends com.tencent.mm.wallet_core.c.a<cbl, k>
{
  private cbl dYH()
  {
    AppMethodBeat.i(68457);
    if (((k)this.gVa).scene == 2)
    {
      AppMethodBeat.o(68457);
      return null;
    }
    Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsq, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68457);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cbl)new cbl().parseFrom((byte[])localObject);
      AppMethodBeat.o(68457);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(68457);
    }
    return null;
  }
  
  public final void c(c.a<cbl> parama)
  {
    AppMethodBeat.i(182498);
    ad.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (((k)this.gVa).scene == 2)
    {
      AppMethodBeat.o(182498);
      return;
    }
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cbl)parama.gUK).ntx == 0)) {
      try
      {
        parama = new String(((cbl)parama.gUK).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ae.a.Fsq, parama);
        AppMethodBeat.o(182498);
        return;
      }
      catch (IOException parama)
      {
        ad.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.r
 * JD-Core Version:    0.7.0.1
 */