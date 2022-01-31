package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class t$2
  implements Runnable
{
  t$2(t paramt, int paramInt, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(4602);
    ab.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(this.tbD), Long.valueOf(this.tbE) });
    if ((!f.Mz()) && (!t.fi(ah.getContext())))
    {
      ab.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
      AppMethodBeat.o(4602);
      return;
    }
    if (this.tzi.tyR.cOc())
    {
      ab.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
      if ((this.tzi.tyR.ttm.tvj.nMZ != this.tbD) && (this.tzi.tyR.ttm.tvj.nNa != this.tbE))
      {
        ab.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(this.tbD), Long.valueOf(this.tbE), Integer.valueOf(this.tzi.tyR.ttm.tvj.nMZ), Long.valueOf(this.tzi.tyR.ttm.tvj.nNa) });
        u.a(this.tbD, this.tbE, 2, null, null, t.b(this.tzi));
      }
      AppMethodBeat.o(4602);
      return;
    }
    new e(this.tbD, this.tbE, "").cOs();
    if (!t.c(this.tzi))
    {
      a.c(this.tbD, this.tbE, 1, 2);
      t.d(this.tzi);
    }
    AppMethodBeat.o(4602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t.2
 * JD-Core Version:    0.7.0.1
 */