package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.i;

final class k$1
  implements com.tencent.soter.a.e.a
{
  k$1(k paramk) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(10559);
    d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    k.ff(com.tencent.soter.core.c.e.dVl().Bmr, 0);
    this.Bop.b(new c(paramInt, paramString));
    AppMethodBeat.o(10559);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(10560);
    d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
    if (this.Bop.Bon != null) {
      k.ff(com.tencent.soter.core.c.e.dVl().Bmr, 2);
    }
    k localk;
    i locali;
    for (;;)
    {
      localk = this.Bop;
      locali = com.tencent.soter.core.a.dVh();
      if (locali != null) {
        break;
      }
      d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
      com.tencent.soter.core.a.dVe();
      localk.b(new c(3, "ask model is null even after generation."));
      AppMethodBeat.o(10560);
      return;
      k.ff(com.tencent.soter.core.c.e.dVl().Bmr, 0);
    }
    if (localk.Bon != null)
    {
      localk.Bon.bK(new e.a(locali.signature, locali.Bmw));
      localk.Bon.a(new k.2(localk, locali));
      localk.Bon.execute();
      AppMethodBeat.o(10560);
      return;
    }
    d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
    localk.b(new c("treat as normal because you do not provide the net wrapper", locali));
    AppMethodBeat.o(10560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.k.1
 * JD-Core Version:    0.7.0.1
 */