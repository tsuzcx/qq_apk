package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$2
  implements ap.a
{
  e$2(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135305);
    ab.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
    Object localObject = this.tKU;
    g.Rc().a(795, (f)localObject);
    localObject = new b(c.cQm().tLy.tAb, c.cQm().tLy.nNa);
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(135305);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.e.2
 * JD-Core Version:    0.7.0.1
 */