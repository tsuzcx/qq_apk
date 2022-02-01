package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.ye.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<ye>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = ye.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(ye paramye)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramye instanceof ye))
    {
      if (!g.ajM())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = com.tencent.mm.plugin.voip_cs.c.c.eFk();
      localObject = paramye.dNy.dNz;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramye = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramye, 0, paramye.length);
        localObject = new dyv();
      }
    }
    try
    {
      ((dyv)localObject).parseFrom(paramye);
      ae.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((dyv)localObject).Ieg + ",notifySeq = " + locale.CMP);
      paramye = new dzc();
      paramye.HSD = ((dyv)localObject).HSD;
      paramye.Gxr = ((dyv)localObject).Gxr;
      paramye.Iee = ((dyv)localObject).Iee;
      paramye.Ieg = ((dyv)localObject).Ieg;
      paramye.Ieh = ((dyv)localObject).Ieh;
      paramye.Iei = ((dyv)localObject).Iei;
      paramye.Ief = ((dyv)localObject).Ief;
      locale.a(paramye);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramye)
    {
      for (;;)
      {
        ae.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramye });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */