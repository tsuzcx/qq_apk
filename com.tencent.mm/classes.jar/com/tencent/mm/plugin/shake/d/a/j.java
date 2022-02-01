package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean icd = false;
  public static j xzm;
  private boolean isActive;
  private long mmC;
  public a xzl;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.xzl = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((xzm == null) || (xzm.xxk == null)) {
      xzm = new j(parama);
    }
    parama = xzm;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.xxk != null) {
      this.xxk.d(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(28313);
    this.xzl.NX();
    super.dCP();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!icd)
    {
      if (!this.xzl.dDL())
      {
        ac.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      icd = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.xxk == null)
    {
      ac.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.mmC = System.currentTimeMillis();
    this.xzl.a(367, new a.a()
    {
      public final void b(cqk paramAnonymouscqk, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          ac.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        cxo localcxo = (cxo)paramAnonymouscqk;
        if (localcxo == null)
        {
          ac.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localcxo.FCh == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localcxo == null) || (bs.isNullOrNil(localcxo.FHm))) {
              break label458;
            }
            ac.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcxo.FHl), localcxo.FHm });
            localObject = localcxo.FHm;
            paramAnonymouscqk = (cqk)localObject;
            if (localObject != null) {
              paramAnonymouscqk = ((String)localObject).trim();
            }
            switch (localcxo.FHl)
            {
            default: 
              ac.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localcxo.FHl);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            h.wUl.n(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymouscqk);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymouscqk);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymouscqk);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymouscqk);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymouscqk);
          }
          label399:
          h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.wUl.n(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.wUl.n(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          h.wUl.n(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymouscqk = new ArrayList();
        if (localcxo != null)
        {
          localObject = new d();
          if ((localcxo.FHh != null) && (localcxo.FHh.getBuffer() != null)) {
            ((d)localObject).field_username = localcxo.FHh.getBuffer().eQU();
          }
          if ((localcxo.FHg != null) && (localcxo.FHg.getBuffer() != null)) {
            ((d)localObject).field_nickname = localcxo.FHg.getBuffer().eQU();
          }
          if ((localcxo.FHh != null) && (localcxo.FHh.getBuffer() != null)) {
            ((d)localObject).field_distance = localcxo.FHh.getBuffer().eQU();
          }
          if ((localcxo.ESK != null) && (localcxo.ESK.getBuffer() != null)) {
            ((d)localObject).field_sns_bgurl = localcxo.ESK.getBuffer().eQU();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localcxo.toByteArray();
          m.dDl().a((d)localObject, true);
          paramAnonymouscqk.add(localObject);
          j.c(j.this).d(paramAnonymouscqk, paramAnonymousLong);
          AppMethodBeat.o(28308);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ac.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
          }
        }
      }
    });
    AppMethodBeat.o(28311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */