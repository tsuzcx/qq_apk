package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class l$1
  implements a.a
{
  l$1(l paraml) {}
  
  public final void b(bvk parambvk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(24656);
    ab.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramBoolean) });
    cbr localcbr;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if (paramLong > l.a(this.qPj))
    {
      paramLong = System.currentTimeMillis() - paramLong;
      if ((parambvk == null) || (bo.isNullOrNil(((cbr)parambvk).wzV))) {
        break label542;
      }
      localcbr = (cbr)parambvk;
      ab.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcbr.jKs), localcbr.wzV });
      localObject2 = null;
      localObject3 = null;
      parambvk = localObject3;
      localObject1 = localObject2;
      if (localcbr.wzV != null)
      {
        localcbr.wzV = localcbr.wzV.trim();
        i = localcbr.wzV.indexOf("<tvinfo>");
        if (i <= 0) {
          break label358;
        }
        localObject1 = localcbr.wzV.substring(0, i);
        parambvk = localcbr.wzV.substring(i);
      }
      label171:
      l.Zd(parambvk);
      switch (localcbr.jKs)
      {
      default: 
        ab.w("Micromsg.ShakeTVService", "parse unknown type:" + localcbr.jKs);
        l.a(this.qPj, new ArrayList());
        paramBoolean = false;
        label266:
        if (paramBoolean)
        {
          h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(this.qPj))) });
          h.qsU.j(835L, 0L, 1L);
        }
        break;
      }
    }
    for (;;)
    {
      l.ES();
      AppMethodBeat.o(24656);
      return;
      paramLong = System.currentTimeMillis() - l.a(this.qPj);
      break;
      label358:
      if (i == 0)
      {
        parambvk = localcbr.wzV;
        localObject1 = localObject2;
        break label171;
      }
      localObject1 = localcbr.wzV;
      parambvk = localObject3;
      break label171;
      paramBoolean = l.a(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.b(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.c(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.d(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.e(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.f(this.qPj, (String)localObject1);
      break label266;
      paramBoolean = l.g(this.qPj, (String)localObject1);
      break label266;
      h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramLong) });
      h.qsU.j(835L, 4L, 1L);
      continue;
      label542:
      if (paramBoolean)
      {
        l.a(this.qPj, new ArrayList());
        h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramLong) });
        h.qsU.j(835L, 3L, 1L);
      }
      else
      {
        l.a(this.qPj, new ArrayList());
        h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramLong) });
        h.qsU.j(835L, 2L, 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l.1
 * JD-Core Version:    0.7.0.1
 */