package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.talkroom.b.c;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.sdk.platformtools.ae;

final class g$6
  extends c.a
{
  g$6(g paramg) {}
  
  public final void k(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g.b(this.pBx, 0);
      g.a(this.pBx).ny("");
    }
    do
    {
      return;
      g.c(this.pBx, paramInt2);
    } while (g.i(this.pBx) == paramInt1);
    g.b(this.pBx, paramInt1);
    String str = this.pBx.bMD();
    if ((!g.j(this.pBx)) && (str == null))
    {
      g.k(this.pBx);
      paramInt1 = g.e(this.pBx);
      long l = g.f(this.pBx);
      Object localObject = g.g(this.pBx);
      g localg = this.pBx;
      g.g(this.pBx);
      localObject = new c(paramInt1, l, (String)localObject, localg.bMC());
      com.tencent.mm.model.au.Dk().a((m)localObject, 0);
      localObject = b.bMx();
      ((f)localObject).pAK += 1;
      localObject = b.bMx();
      ((f)localObject).pAL += 1;
    }
    g.a(this.pBx).ny(str);
    com.tencent.mm.sdk.platformtools.au.G(ae.getContext(), R.l.talkroom_othersbegin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.6
 * JD-Core Version:    0.7.0.1
 */