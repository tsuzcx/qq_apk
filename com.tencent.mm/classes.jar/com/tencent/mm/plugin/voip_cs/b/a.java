package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.a.xy.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<xy>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = xy.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(xy paramxy)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramxy instanceof xy))
    {
      if (!g.ajx())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = com.tencent.mm.plugin.voip_cs.c.c.eBC();
      localObject = paramxy.dMi.dMj;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramxy = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramxy, 0, paramxy.length);
        localObject = new dxe();
      }
    }
    try
    {
      ((dxe)localObject).parseFrom(paramxy);
      ad.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((dxe)localObject).HJY + ",notifySeq = " + locale.Cvk);
      paramxy = new dxl();
      paramxy.HyS = ((dxe)localObject).HyS;
      paramxy.GeJ = ((dxe)localObject).GeJ;
      paramxy.HJW = ((dxe)localObject).HJW;
      paramxy.HJY = ((dxe)localObject).HJY;
      paramxy.HJZ = ((dxe)localObject).HJZ;
      paramxy.HKa = ((dxe)localObject).HKa;
      paramxy.HJX = ((dxe)localObject).HJX;
      locale.a(paramxy);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramxy)
    {
      for (;;)
      {
        ad.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramxy });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */