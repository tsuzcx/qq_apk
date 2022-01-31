package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.b.d;
import com.tencent.mm.sdk.platformtools.am.a;

final class g$3
  implements am.a
{
  g$3(g paramg) {}
  
  public final boolean tC()
  {
    int i = g.e(this.pBx);
    long l = g.f(this.pBx);
    Object localObject = g.g(this.pBx);
    g localg = this.pBx;
    g.g(this.pBx);
    localObject = new d(i, l, 1, (String)localObject, localg.bMC());
    au.Dk().a((m)localObject, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.3
 * JD-Core Version:    0.7.0.1
 */