package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.a.xe.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<xe>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = xe.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(xe paramxe)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramxe instanceof xe))
    {
      if (!g.agM())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = com.tencent.mm.plugin.voip_cs.c.c.enD();
      localObject = paramxe.dzV.dzW;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramxe = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramxe, 0, paramxe.length);
        localObject = new drk();
      }
    }
    try
    {
      ((drk)localObject).parseFrom(paramxe);
      ac.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((drk)localObject).FZc + ",notifySeq = " + locale.AVc);
      paramxe = new drr();
      paramxe.FOh = ((drk)localObject).FOh;
      paramxe.Exg = ((drk)localObject).Exg;
      paramxe.FZa = ((drk)localObject).FZa;
      paramxe.FZc = ((drk)localObject).FZc;
      paramxe.FZd = ((drk)localObject).FZd;
      paramxe.FZe = ((drk)localObject).FZe;
      paramxe.FZb = ((drk)localObject).FZb;
      locale.a(paramxe);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramxe)
    {
      for (;;)
      {
        ac.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramxe });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */