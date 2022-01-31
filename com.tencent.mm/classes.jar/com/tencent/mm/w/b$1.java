package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;

final class b$1
  implements n.b
{
  b$1(b paramb) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(124474);
    if (!b.Pq())
    {
      AppMethodBeat.o(124474);
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      paramn = (String)paramObject;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124474);
      return;
      paramn = null;
      break;
      if (paramn != null)
      {
        this.ezi.ezf.a(65636, new b.f(this.ezi, paramn));
        AppMethodBeat.o(124474);
        return;
        if (paramn == null)
        {
          this.ezi.ezf.a(65636, new b.c(this.ezi));
          AppMethodBeat.o(124474);
          return;
        }
        this.ezi.ezf.a(65636, new b.d(this.ezi, paramn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.w.b.1
 * JD-Core Version:    0.7.0.1
 */