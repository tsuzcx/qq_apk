package com.tencent.soter.a.g;

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
    d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[] { this.wQS.wPD, Integer.valueOf(paramInt), paramString });
    l.dV(this.wQS.wPD, 0);
    this.wQS.b(new c(paramInt, paramString));
  }
  
  public final void onSuccess()
  {
    d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
    if (this.wQS.psg != null) {
      l.dV(this.wQS.wPD, 2);
    }
    l locall;
    i locali;
    for (;;)
    {
      locall = this.wQS;
      locali = com.tencent.soter.core.a.afR(locall.wPD);
      if (locali != null) {
        break;
      }
      d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
      com.tencent.soter.core.a.bR(locall.wPD, false);
      locall.b(new c(12, "auth key model is null even after generation."));
      return;
      l.dV(this.wQS.wPD, 0);
    }
    if (locall.psg != null)
    {
      locall.psg.bj(new e.a(locali.signature, locali.wOY));
      locall.psg.a(new l.3(locall, locali));
      locall.psg.execute();
      return;
    }
    d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
    locall.b(new c("treat as normal because you do not provide the net wrapper", locali));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.l.2
 * JD-Core Version:    0.7.0.1
 */