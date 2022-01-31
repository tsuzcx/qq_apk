package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class t$3
  implements ap.a
{
  t$3(t paramt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4603);
    ab.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
    if (t.e(this.tzi) == null)
    {
      t.f(this.tzi);
      t.g(this.tzi).stopTimer();
      AppMethodBeat.o(4603);
      return false;
    }
    if (t.fi(ah.getContext()))
    {
      this.tzi.ah(t.e(this.tzi).wQP, t.e(this.tzi).wQQ);
      this.tzi.b(t.e(this.tzi));
      t.h(this.tzi);
      t.f(this.tzi);
      t.g(this.tzi).stopTimer();
      h.qsU.idkeyStat(500L, 5L, 1L, false);
      AppMethodBeat.o(4603);
      return false;
    }
    if (System.currentTimeMillis() - t.i(this.tzi) < 60000L)
    {
      AppMethodBeat.o(4603);
      return true;
    }
    t.h(this.tzi);
    t.f(this.tzi);
    t.g(this.tzi).stopTimer();
    AppMethodBeat.o(4603);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t.3
 * JD-Core Version:    0.7.0.1
 */