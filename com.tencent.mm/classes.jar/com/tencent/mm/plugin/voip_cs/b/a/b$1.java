package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135318);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
    c.cQo().dataType = 1;
    this.tLv.If(6);
    AppMethodBeat.o(135318);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.1
 * JD-Core Version:    0.7.0.1
 */