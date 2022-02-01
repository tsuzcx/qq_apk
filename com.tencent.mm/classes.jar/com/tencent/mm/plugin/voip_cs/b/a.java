package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.g.a.wt.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<wt>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = wt.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(wt paramwt)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramwt instanceof wt))
    {
      if (!g.afw())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = com.tencent.mm.plugin.voip_cs.c.c.dYh();
      localObject = paramwt.dCh.dCi;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramwt = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramwt, 0, paramwt.length);
        localObject = new dlt();
      }
    }
    try
    {
      ((dlt)localObject).parseFrom(paramwt);
      ad.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((dlt)localObject).EBP + ",notifySeq = " + locale.zCP);
      paramwt = new dma();
      paramwt.Erf = ((dlt)localObject).Erf;
      paramwt.Dea = ((dlt)localObject).Dea;
      paramwt.EBN = ((dlt)localObject).EBN;
      paramwt.EBP = ((dlt)localObject).EBP;
      paramwt.EBQ = ((dlt)localObject).EBQ;
      paramwt.EBR = ((dlt)localObject).EBR;
      paramwt.EBO = ((dlt)localObject).EBO;
      locale.a(paramwt);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramwt)
    {
      for (;;)
      {
        ad.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramwt });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */