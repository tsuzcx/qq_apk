package com.tencent.mm.plugin.voip_cs.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.voip_cs.model.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class e$2
  implements MTimerHandler.CallBack
{
  e$2(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125357);
    Log.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
    Object localObject = this.UXX;
    com.tencent.mm.kernel.h.aZW().a(795, (com.tencent.mm.am.h)localObject);
    localObject = new b(c.idW().UYC.UDu, c.idW().UYC.Hnt);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(125357);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.e.2
 * JD-Core Version:    0.7.0.1
 */