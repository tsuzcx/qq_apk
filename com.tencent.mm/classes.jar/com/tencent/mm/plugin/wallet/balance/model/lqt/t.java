package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import java.io.IOException;

public final class t
  extends com.tencent.mm.wallet_core.model.a<efy, l>
{
  private efy ieu()
  {
    AppMethodBeat.i(68457);
    if (((l)this.otu).scene == 2)
    {
      AppMethodBeat.o(68457);
      return null;
    }
    Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVl, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(68457);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.b.a.ISO_8859_1);
    try
    {
      localObject = (efy)new efy().parseFrom((byte[])localObject);
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
  
  public final void b(b.a<efy> parama)
  {
    AppMethodBeat.i(182498);
    Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (((l)this.otu).scene == 2)
    {
      AppMethodBeat.o(182498);
      return;
    }
    if ((parama.errType == 0) && (parama.errCode == 0) && (((efy)parama.ott).wuz == 0)) {
      try
      {
        parama = new String(((efy)parama.ott).toByteArray(), org.apache.commons.b.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.acVl, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t
 * JD-Core Version:    0.7.0.1
 */