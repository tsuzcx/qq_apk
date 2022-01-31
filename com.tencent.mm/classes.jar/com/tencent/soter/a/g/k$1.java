package com.tencent.soter.a.g;

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
    d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    k.dV(com.tencent.soter.core.c.e.cPq().wOT, 0);
    this.wQP.b(new c(paramInt, paramString));
  }
  
  public final void onSuccess()
  {
    d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
    if (this.wQP.wQN != null) {
      k.dV(com.tencent.soter.core.c.e.cPq().wOT, 2);
    }
    k localk;
    i locali;
    for (;;)
    {
      localk = this.wQP;
      locali = com.tencent.soter.core.a.cPm();
      if (locali != null) {
        break;
      }
      d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
      com.tencent.soter.core.a.cPj();
      localk.b(new c(3, "ask model is null even after generation."));
      return;
      k.dV(com.tencent.soter.core.c.e.cPq().wOT, 0);
    }
    if (localk.wQN != null)
    {
      localk.wQN.bj(new e.a(locali.signature, locali.wOY));
      localk.wQN.a(new k.2(localk, locali));
      localk.wQN.execute();
      return;
    }
    d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
    localk.b(new c("treat as normal because you do not provide the net wrapper", locali));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.k.1
 * JD-Core Version:    0.7.0.1
 */