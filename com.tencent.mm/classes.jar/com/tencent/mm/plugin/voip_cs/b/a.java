package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aan;
import com.tencent.mm.f.a.aan.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.protocal.protobuf.fdu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
  extends IListener<aan>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = aan.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(aan paramaan)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramaan instanceof aan))
    {
      if (!h.aHB())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = c.gEW();
      localObject = paramaan.fZG.fZH;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramaan = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramaan, 0, paramaan.length);
        localObject = new fdn();
      }
    }
    try
    {
      ((fdn)localObject).parseFrom(paramaan);
      Log.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((fdn)localObject).UDA + ",notifySeq = " + locale.Ojq);
      paramaan = new fdu();
      paramaan.Urf = ((fdn)localObject).Urf;
      paramaan.Svv = ((fdn)localObject).Svv;
      paramaan.UDy = ((fdn)localObject).UDy;
      paramaan.UDA = ((fdn)localObject).UDA;
      paramaan.UDB = ((fdn)localObject).UDB;
      paramaan.UDC = ((fdn)localObject).UDC;
      paramaan.UDz = ((fdn)localObject).UDz;
      locale.a(paramaan);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramaan)
    {
      for (;;)
      {
        Log.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramaan });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */