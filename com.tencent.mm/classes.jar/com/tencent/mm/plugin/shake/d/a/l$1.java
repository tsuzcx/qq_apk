package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class l$1
  implements a.a
{
  l$1(l paraml) {}
  
  public final void b(bly parambly, long paramLong, boolean paramBoolean)
  {
    y.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramBoolean) });
    brg localbrg;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if (paramLong > l.a(this.oba))
    {
      paramLong = System.currentTimeMillis() - paramLong;
      if ((parambly == null) || (bk.bl(((brg)parambly).sDW))) {
        break label528;
      }
      localbrg = (brg)parambly;
      y.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localbrg.hQR), localbrg.sDW });
      localObject2 = null;
      localObject3 = null;
      parambly = localObject3;
      localObject1 = localObject2;
      if (localbrg.sDW != null)
      {
        localbrg.sDW = localbrg.sDW.trim();
        i = localbrg.sDW.indexOf("<tvinfo>");
        if (i <= 0) {
          break label344;
        }
        localObject1 = localbrg.sDW.substring(0, i);
        parambly = localbrg.sDW.substring(i);
      }
      label165:
      l.Mv(parambly);
      switch (localbrg.hQR)
      {
      default: 
        y.w("Micromsg.ShakeTVService", "parse unknown type:" + localbrg.hQR);
        l.a(this.oba, new ArrayList());
        paramBoolean = false;
        label258:
        if (paramBoolean)
        {
          h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(this.oba))) });
          h.nFQ.h(835L, 0L, 1L);
        }
        break;
      }
    }
    for (;;)
    {
      l.bAz();
      return;
      paramLong = System.currentTimeMillis() - l.a(this.oba);
      break;
      label344:
      if (i == 0)
      {
        parambly = localbrg.sDW;
        localObject1 = localObject2;
        break label165;
      }
      localObject1 = localbrg.sDW;
      parambly = localObject3;
      break label165;
      paramBoolean = l.a(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.b(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.c(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.d(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.e(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.f(this.oba, (String)localObject1);
      break label258;
      paramBoolean = l.g(this.oba, (String)localObject1);
      break label258;
      h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramLong) });
      h.nFQ.h(835L, 4L, 1L);
      continue;
      label528:
      if (paramBoolean)
      {
        l.a(this.oba, new ArrayList());
        h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramLong) });
        h.nFQ.h(835L, 3L, 1L);
      }
      else
      {
        l.a(this.oba, new ArrayList());
        h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramLong) });
        h.nFQ.h(835L, 2L, 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l.1
 * JD-Core Version:    0.7.0.1
 */