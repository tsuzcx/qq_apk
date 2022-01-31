package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.i;

final class l$2
  implements com.tencent.soter.a.e.a
{
  l$2(l paraml) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(10566);
    d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[] { this.Bos.Bnd, Integer.valueOf(paramInt), paramString });
    l.ff(this.Bos.Bnd, 0);
    this.Bos.b(new c(paramInt, paramString));
    AppMethodBeat.o(10566);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(10567);
    d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
    if (this.Bos.soi != null) {
      l.ff(this.Bos.Bnd, 2);
    }
    l locall;
    i locali;
    for (;;)
    {
      locall = this.Bos;
      locali = com.tencent.soter.core.a.awM(locall.Bnd);
      if (locali != null) {
        break;
      }
      d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
      com.tencent.soter.core.a.cu(locall.Bnd, false);
      locall.b(new c(12, "auth key model is null even after generation."));
      AppMethodBeat.o(10567);
      return;
      l.ff(this.Bos.Bnd, 0);
    }
    if (locall.soi != null)
    {
      locall.soi.bK(new e.a(locali.signature, locali.Bmw));
      locall.soi.a(new l.3(locall, locali));
      locall.soi.execute();
      AppMethodBeat.o(10567);
      return;
    }
    d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
    locall.b(new c("treat as normal because you do not provide the net wrapper", locali));
    AppMethodBeat.o(10567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.l.2
 * JD-Core Version:    0.7.0.1
 */