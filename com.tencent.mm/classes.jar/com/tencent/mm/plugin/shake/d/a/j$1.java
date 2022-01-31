package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class j$1
  implements a.a
{
  j$1(j paramj) {}
  
  public final void b(bly parambly, long paramLong, boolean paramBoolean)
  {
    if (j.a(this.oaY) == null)
    {
      y.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      return;
    }
    brc localbrc = (brc)parambly;
    if (localbrc == null)
    {
      y.w("Micromsg.ShakeMusicMgr", "resp null & return");
      j.a(this.oaY, new ArrayList());
      return;
    }
    Object localObject;
    if (localbrc.tHX == 1)
    {
      if (paramLong > j.b(this.oaY))
      {
        paramLong = System.currentTimeMillis() - paramLong;
        if ((localbrc == null) || (bk.bl(localbrc.tHZ))) {
          break label426;
        }
        y.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localbrc.tHY), localbrc.tHZ });
        localObject = localbrc.tHZ;
        parambly = (bly)localObject;
        if (localObject != null) {
          parambly = ((String)localObject).trim();
        }
        switch (localbrc.tHY)
        {
        default: 
          y.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localbrc.tHY);
          j.a(this.oaY, new ArrayList());
          paramBoolean = false;
        }
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label373;
        }
        h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(this.oaY))) });
        h.nFQ.h(835L, 0L, 1L);
        return;
        paramLong = System.currentTimeMillis() - j.b(this.oaY);
        break;
        paramBoolean = j.a(this.oaY, parambly);
        continue;
        paramBoolean = j.b(this.oaY, parambly);
        continue;
        paramBoolean = j.c(this.oaY, parambly);
        continue;
        paramBoolean = j.d(this.oaY, parambly);
        continue;
        paramBoolean = j.e(this.oaY, parambly);
      }
      label373:
      h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramLong) });
      h.nFQ.h(835L, 4L, 1L);
      return;
      label426:
      if (paramBoolean)
      {
        j.a(this.oaY, new ArrayList());
        h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramLong) });
        h.nFQ.h(835L, 3L, 1L);
        return;
      }
      j.a(this.oaY, new ArrayList());
      h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramLong) });
      h.nFQ.h(835L, 2L, 1L);
      return;
    }
    parambly = new ArrayList();
    if (localbrc != null)
    {
      localObject = new d();
      if ((localbrc.tHT != null) && (localbrc.tHT.tFM != null)) {
        ((d)localObject).field_username = localbrc.tHT.tFM.coM();
      }
      if ((localbrc.tHS != null) && (localbrc.tHS.tFM != null)) {
        ((d)localObject).field_nickname = localbrc.tHS.tFM.coM();
      }
      if ((localbrc.tHT != null) && (localbrc.tHT.tFM != null)) {
        ((d)localObject).field_distance = localbrc.tHT.tFM.coM();
      }
      if ((localbrc.tfZ != null) && (localbrc.tfZ.tFM != null)) {
        ((d)localObject).field_sns_bgurl = localbrc.tfZ.tFM.coM();
      }
      ((d)localObject).field_type = 4;
      ((d)localObject).field_insertBatch = 1;
    }
    try
    {
      ((d)localObject).field_lvbuffer = localbrc.toByteArray();
      m.bzU().a((d)localObject, true);
      parambly.add(localObject);
      j.c(this.oaY).a(parambly, paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j.1
 * JD-Core Version:    0.7.0.1
 */