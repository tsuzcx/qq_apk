package com.tencent.mm.plugin.sns.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class c$2
  implements b.f
{
  c$2(c paramc, long paramLong) {}
  
  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramb, long paramLong)
  {
    AppMethodBeat.i(40095);
    if (paramLong >= 3L)
    {
      i = (int)paramb.cmE();
      this.sge.rOU.c(this.sgd, bo.yB(), false);
      this.sge.rOU.f(this.sgd, i, false);
      this.sge.rOU.V(this.sgd, this.sgd);
    }
    ab.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramLong) });
    int i = (int)paramLong;
    paramb = this.sge;
    Object localObject = this.sge.sgc;
    n localn = this.sge.rMD;
    i *= 1000;
    localObject = ((b.c)localObject).rqY;
    if ((!bo.isNullOrNil(localn.csb().cqw())) && (localObject != null) && (((b.c.a)localObject).startTime >= 0L) && (((b.c.a)localObject).endTime > ((b.c.a)localObject).startTime))
    {
      ab.i("MicroMsg.FullCardAdDetailItem", "%d-%d,%d", new Object[] { Long.valueOf(((b.c.a)localObject).startTime), Long.valueOf(((b.c.a)localObject).endTime), Integer.valueOf(i) });
      if ((((b.c.a)localObject).startTime <= i) && (((b.c.a)localObject).endTime >= i))
      {
        if (paramb.sgb.getOnGestureListener() == null)
        {
          al.d(new c.4(paramb, (b.c.a)localObject, localn));
          AppMethodBeat.o(40095);
        }
      }
      else {
        al.d(new c.5(paramb));
      }
    }
    AppMethodBeat.o(40095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c.2
 * JD-Core Version:    0.7.0.1
 */