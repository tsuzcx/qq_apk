package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.y;
import java.io.IOException;

public final class o
  extends com.tencent.mm.wallet_core.c.a<bnd, h>
{
  private bnd cQL()
  {
    AppMethodBeat.i(45244);
    if (((h)this.fsO).scene == 2)
    {
      AppMethodBeat.o(45244);
      return null;
    }
    Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)g.G(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ac.a.yJr, "");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(45244);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bnd)new bnd().parseFrom((byte[])localObject);
      AppMethodBeat.o(45244);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(45244);
    }
    return null;
  }
  
  public final void e(a.a<bnd> parama)
  {
    AppMethodBeat.i(45243);
    ab.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (((h)this.fsO).scene == 2)
    {
      AppMethodBeat.o(45243);
      return;
    }
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bnd)parama.fsN).koj == 0)) {
      try
      {
        parama = new String(((bnd)parama.fsN).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)g.G(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ac.a.yJr, parama);
        AppMethodBeat.o(45243);
        return;
      }
      catch (IOException parama)
      {
        ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(45243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.o
 * JD-Core Version:    0.7.0.1
 */