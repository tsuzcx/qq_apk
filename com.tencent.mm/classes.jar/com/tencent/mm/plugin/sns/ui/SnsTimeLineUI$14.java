package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.c.a;

final class SnsTimeLineUI$14
  implements a<Void, Void>
{
  SnsTimeLineUI$14(SnsTimeLineUI paramSnsTimeLineUI, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString, long paramLong, boolean paramBoolean3) {}
  
  private Void a(Void paramVoid)
  {
    AppMethodBeat.i(39465);
    if (SnsTimeLineUI.j(this.rYv) != null)
    {
      SnsTimeLineUI.k(this.rYv);
      SnsTimeLineUI.j(this.rYv).cwr();
    }
    SnsTimeLineUI.l(this.rYv).kyS = this.rYw;
    if (this.rYv.rYo == 0)
    {
      ab.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(this.rYw) });
      if (this.rYw) {
        SnsTimeLineUI.l(this.rYv).lu(false);
      }
      AppMethodBeat.o(39465);
      return paramVoid;
    }
    if ((this.rYB) && (!SnsTimeLineUI.r(this.rYv).equals(SnsTimeLineUI.n(this.rYv))))
    {
      SnsTimeLineUI.l(this.rYv).kyS = true;
      SnsTimeLineUI.l(this.rYv).bf(this.rYx, this.rYy);
    }
    for (;;)
    {
      AppMethodBeat.o(39465);
      return paramVoid;
      if ((SnsTimeLineUI.r(this.rYv).equals(SnsTimeLineUI.n(this.rYv))) && (this.rYC != 0L))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yEZ, Long.valueOf(this.rYC));
      }
      if (this.rYw) {
        SnsTimeLineUI.l(this.rYv).lu(this.rYD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.14
 * JD-Core Version:    0.7.0.1
 */