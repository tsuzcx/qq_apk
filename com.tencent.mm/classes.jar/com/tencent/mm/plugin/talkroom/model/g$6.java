package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.talkroom.b.c;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ay;

final class g$6
  extends c.a
{
  g$6(g paramg) {}
  
  public final void p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(25810);
    if (paramBoolean)
    {
      g.b(this.tdh, 0);
      g.a(this.tdh).uM("");
      AppMethodBeat.o(25810);
      return;
    }
    g.c(this.tdh, paramInt2);
    if (g.i(this.tdh) == paramInt1)
    {
      AppMethodBeat.o(25810);
      return;
    }
    g.b(this.tdh, paramInt1);
    String str = this.tdh.cHF();
    if ((!g.j(this.tdh)) && (str == null))
    {
      g.k(this.tdh);
      paramInt1 = g.e(this.tdh);
      long l = g.f(this.tdh);
      Object localObject = g.g(this.tdh);
      g localg = this.tdh;
      g.g(this.tdh);
      localObject = new c(paramInt1, l, (String)localObject, localg.cHE());
      aw.Rc().a((m)localObject, 0);
      localObject = b.cHv();
      ((f)localObject).tcu += 1;
      localObject = b.cHv();
      ((f)localObject).tcv += 1;
    }
    g.a(this.tdh).uM(str);
    ay.ax(ah.getContext(), 2131304256);
    AppMethodBeat.o(25810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.6
 * JD-Core Version:    0.7.0.1
 */