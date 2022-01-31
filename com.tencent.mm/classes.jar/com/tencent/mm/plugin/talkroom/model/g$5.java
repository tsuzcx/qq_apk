package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.b.e;
import com.tencent.mm.sdk.platformtools.ac.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$5
  implements ac.a
{
  g$5(g paramg) {}
  
  public final boolean tC()
  {
    if ((g.e(this.pBx) == 0) || (bk.bl(g.g(this.pBx))))
    {
      y.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(this.pBx)), g.g(this.pBx) });
      g.h(this.pBx);
      return false;
    }
    Object localObject = g.g(this.pBx);
    int i = g.e(this.pBx);
    long l = g.f(this.pBx);
    g localg = this.pBx;
    g.g(this.pBx);
    localObject = new e((String)localObject, i, l, localg.bMC());
    au.Dk().a((m)localObject, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.5
 * JD-Core Version:    0.7.0.1
 */