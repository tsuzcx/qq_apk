package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class n
  extends com.tencent.mm.wallet_core.c.a<bmn, g>
{
  private static bmn cQK()
  {
    AppMethodBeat.i(45241);
    Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJp, "");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(45241);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bmn)new bmn().parseFrom((byte[])localObject);
      AppMethodBeat.o(45241);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(45241);
    }
    return null;
  }
  
  public final void e(a.a<bmn> parama)
  {
    AppMethodBeat.i(45240);
    ab.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bmn)parama.fsN).koj == 0)) {
      try
      {
        parama = new String(((bmn)parama.fsN).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJp, parama);
        AppMethodBeat.o(45240);
        return;
      }
      catch (IOException parama)
      {
        ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(45240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.n
 * JD-Core Version:    0.7.0.1
 */