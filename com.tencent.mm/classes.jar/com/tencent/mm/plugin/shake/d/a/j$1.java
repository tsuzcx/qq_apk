package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class j$1
  implements a.a
{
  j$1(j paramj) {}
  
  public final void b(bvk parambvk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(24638);
    if (j.a(this.qPh) == null)
    {
      ab.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(24638);
      return;
    }
    cbn localcbn = (cbn)parambvk;
    if (localcbn == null)
    {
      ab.w("Micromsg.ShakeMusicMgr", "resp null & return");
      j.a(this.qPh, new ArrayList());
      AppMethodBeat.o(24638);
      return;
    }
    Object localObject;
    if (localcbn.xHS == 1)
    {
      if (paramLong > j.b(this.qPh))
      {
        paramLong = System.currentTimeMillis() - paramLong;
        if ((localcbn == null) || (bo.isNullOrNil(localcbn.xMq))) {
          break label458;
        }
        ab.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcbn.xMp), localcbn.xMq });
        localObject = localcbn.xMq;
        parambvk = (bvk)localObject;
        if (localObject != null) {
          parambvk = ((String)localObject).trim();
        }
        switch (localcbn.xMp)
        {
        default: 
          ab.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localcbn.xMp);
          j.a(this.qPh, new ArrayList());
          paramBoolean = false;
        }
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label399;
        }
        h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(this.qPh))) });
        h.qsU.j(835L, 0L, 1L);
        AppMethodBeat.o(24638);
        return;
        paramLong = System.currentTimeMillis() - j.b(this.qPh);
        break;
        paramBoolean = j.a(this.qPh, parambvk);
        continue;
        paramBoolean = j.b(this.qPh, parambvk);
        continue;
        paramBoolean = j.c(this.qPh, parambvk);
        continue;
        paramBoolean = j.d(this.qPh, parambvk);
        continue;
        paramBoolean = j.e(this.qPh, parambvk);
      }
      label399:
      h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramLong) });
      h.qsU.j(835L, 4L, 1L);
      AppMethodBeat.o(24638);
      return;
      label458:
      if (paramBoolean)
      {
        j.a(this.qPh, new ArrayList());
        h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramLong) });
        h.qsU.j(835L, 3L, 1L);
        AppMethodBeat.o(24638);
        return;
      }
      j.a(this.qPh, new ArrayList());
      h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramLong) });
      h.qsU.j(835L, 2L, 1L);
      AppMethodBeat.o(24638);
      return;
    }
    parambvk = new ArrayList();
    if (localcbn != null)
    {
      localObject = new d();
      if ((localcbn.xMl != null) && (localcbn.xMl.getBuffer() != null)) {
        ((d)localObject).field_username = localcbn.xMl.getBuffer().dqj();
      }
      if ((localcbn.xMk != null) && (localcbn.xMk.getBuffer() != null)) {
        ((d)localObject).field_nickname = localcbn.xMk.getBuffer().dqj();
      }
      if ((localcbn.xMl != null) && (localcbn.xMl.getBuffer() != null)) {
        ((d)localObject).field_distance = localcbn.xMl.getBuffer().dqj();
      }
      if ((localcbn.xey != null) && (localcbn.xey.getBuffer() != null)) {
        ((d)localObject).field_sns_bgurl = localcbn.xey.getBuffer().dqj();
      }
      ((d)localObject).field_type = 4;
      ((d)localObject).field_insertBatch = 1;
    }
    try
    {
      ((d)localObject).field_lvbuffer = localcbn.toByteArray();
      m.cln().a((d)localObject, true);
      parambvk.add(localObject);
      j.c(this.qPh).b(parambvk, paramLong);
      AppMethodBeat.o(24638);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j.1
 * JD-Core Version:    0.7.0.1
 */