package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zg;
import com.tencent.mm.g.a.zg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.etc;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
  extends IListener<zg>
{
  public a()
  {
    AppMethodBeat.i(161685);
    this.__eventId = zg.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(zg paramzg)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramzg instanceof zg))
    {
      if (!g.aAc())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = c.fMs();
      localObject = paramzg.efr.efs;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramzg = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramzg, 0, paramzg.length);
        localObject = new etc();
      }
    }
    try
    {
      ((etc)localObject).parseFrom(paramzg);
      Log.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((etc)localObject).NqE + ",notifySeq = " + locale.HrF);
      paramzg = new etj();
      paramzg.NeG = ((etc)localObject).NeG;
      paramzg.Lta = ((etc)localObject).Lta;
      paramzg.NqC = ((etc)localObject).NqC;
      paramzg.NqE = ((etc)localObject).NqE;
      paramzg.NqF = ((etc)localObject).NqF;
      paramzg.NqG = ((etc)localObject).NqG;
      paramzg.NqD = ((etc)localObject).NqD;
      locale.a(paramzg);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramzg)
    {
      for (;;)
      {
        Log.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramzg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */