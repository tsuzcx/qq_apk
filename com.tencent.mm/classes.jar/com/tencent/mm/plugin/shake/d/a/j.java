package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean iys = false;
  public static j zeg;
  private boolean isActive;
  private long mSh;
  public a zef;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.zef = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((zeg == null) || (zeg.zcf == null)) {
      zeg = new j(parama);
    }
    parama = zeg;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.zcf != null) {
      this.zcf.d(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void dRP()
  {
    AppMethodBeat.i(28313);
    this.zef.PF();
    super.dRP();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!iys)
    {
      if (!this.zef.dSL())
      {
        ae.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      iys = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.zcf == null)
    {
      ae.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.mSh = System.currentTimeMillis();
    this.zef.a(367, new a.a()
    {
      public final void b(cwj paramAnonymouscwj, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          ae.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        ddv localddv = (ddv)paramAnonymouscwj;
        if (localddv == null)
        {
          ae.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localddv.HFW == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localddv == null) || (bu.isNullOrNil(localddv.HLw))) {
              break label458;
            }
            ae.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localddv.HLv), localddv.HLw });
            localObject = localddv.HLw;
            paramAnonymouscwj = (cwj)localObject;
            if (localObject != null) {
              paramAnonymouscwj = ((String)localObject).trim();
            }
            switch (localddv.HLv)
            {
            default: 
              ae.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localddv.HLv);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            g.yxI.n(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymouscwj);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymouscwj);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymouscwj);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymouscwj);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymouscwj);
          }
          label399:
          g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          g.yxI.n(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            g.yxI.n(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          g.yxI.n(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymouscwj = new ArrayList();
        if (localddv != null)
        {
          localObject = new d();
          if ((localddv.HLr != null) && (localddv.HLr.getBuffer() != null)) {
            ((d)localObject).field_username = localddv.HLr.getBuffer().fjO();
          }
          if ((localddv.HLq != null) && (localddv.HLq.getBuffer() != null)) {
            ((d)localObject).field_nickname = localddv.HLq.getBuffer().fjO();
          }
          if ((localddv.HLr != null) && (localddv.HLr.getBuffer() != null)) {
            ((d)localObject).field_distance = localddv.HLr.getBuffer().fjO();
          }
          if ((localddv.GVD != null) && (localddv.GVD.getBuffer() != null)) {
            ((d)localObject).field_sns_bgurl = localddv.GVD.getBuffer().fjO();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localddv.toByteArray();
          m.dSl().a((d)localObject, true);
          paramAnonymouscwj.add(localObject);
          j.c(j.this).d(paramAnonymouscwj, paramAnonymousLong);
          AppMethodBeat.o(28308);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
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