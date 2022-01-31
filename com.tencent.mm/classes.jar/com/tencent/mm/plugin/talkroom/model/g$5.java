package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.talkroom.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.bo;

final class g$5
  implements af.a
{
  g$5(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25809);
    if ((g.e(this.tdh) == 0) || (bo.isNullOrNil(g.g(this.tdh))))
    {
      ab.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(this.tdh)), g.g(this.tdh) });
      g.h(this.tdh);
      AppMethodBeat.o(25809);
      return false;
    }
    Object localObject = g.g(this.tdh);
    int i = g.e(this.tdh);
    long l = g.f(this.tdh);
    g localg = this.tdh;
    g.g(this.tdh);
    localObject = new e((String)localObject, i, l, localg.cHE());
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(25809);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.5
 * JD-Core Version:    0.7.0.1
 */