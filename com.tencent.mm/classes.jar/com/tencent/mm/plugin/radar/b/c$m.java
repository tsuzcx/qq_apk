package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;

public final class c$m
  implements c.d
{
  public c$m(String paramString, long paramLong) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(localObject1, "service(IMessengerStorage::class.java)");
      Object localObject2 = ((j)localObject1).Fw().abl(paramString1);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        paramBoolean2 = paramBoolean1;
        if (((ad)localObject2).Bo() != 0) {}
      }
      else
      {
        localObject1 = c.a(bi.d.acc(this.nkR));
        localObject2 = com.tencent.mm.kernel.g.r(j.class);
        a.d.b.g.j(localObject2, "service(IMessengerStorage::class.java)");
        if (!((j)localObject2).Fw().V((ad)localObject1))
        {
          localObject2 = c.nkz;
          y.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
          paramBoolean1 = false;
        }
        localObject2 = com.tencent.mm.kernel.g.r(j.class);
        a.d.b.g.j(localObject2, "service(IMessengerStorage::class.java)");
        localObject1 = ((j)localObject2).Fw().abl(((ad)localObject1).getUsername());
        paramBoolean2 = paramBoolean1;
      }
      localObject2 = c.nkz;
      y.d(c.access$getTAG$cp(), "verifyContact return ok");
      s.q((ad)localObject1);
      c.cj(paramString1, 1);
    }
    for (;;)
    {
      c.a(this.nkD, paramBoolean2, paramString2, paramString1, this.nkJ);
      return;
      localObject1 = c.nkz;
      y.d(c.access$getTAG$cp(), "verifyContact return not ok");
      paramBoolean2 = paramBoolean1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.m
 * JD-Core Version:    0.7.0.1
 */