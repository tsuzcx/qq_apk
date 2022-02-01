package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean ivz = false;
  public static j yNW;
  private boolean isActive;
  private long mNe;
  public a yNV;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.yNV = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((yNW == null) || (yNW.yLV == null)) {
      yNW = new j(parama);
    }
    parama = yNW;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.yLV != null) {
      this.yLV.d(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void dOs()
  {
    AppMethodBeat.i(28313);
    this.yNV.PG();
    super.dOs();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!ivz)
    {
      if (!this.yNV.dPo())
      {
        ad.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      ivz = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.yLV == null)
    {
      ad.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.mNe = System.currentTimeMillis();
    this.yNV.a(367, new a.a()
    {
      public final void b(cvp paramAnonymouscvp, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          ad.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        ddb localddb = (ddb)paramAnonymouscvp;
        if (localddb == null)
        {
          ad.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localddb.Hmw == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localddb == null) || (bt.isNullOrNil(localddb.HrU))) {
              break label458;
            }
            ad.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localddb.HrT), localddb.HrU });
            localObject = localddb.HrU;
            paramAnonymouscvp = (cvp)localObject;
            if (localObject != null) {
              paramAnonymouscvp = ((String)localObject).trim();
            }
            switch (localddb.HrT)
            {
            default: 
              ad.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localddb.HrT);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            g.yhR.n(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymouscvp);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymouscvp);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymouscvp);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymouscvp);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymouscvp);
          }
          label399:
          g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          g.yhR.n(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            g.yhR.n(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          g.yhR.n(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymouscvp = new ArrayList();
        if (localddb != null)
        {
          localObject = new d();
          if ((localddb.HrP != null) && (localddb.HrP.getBuffer() != null)) {
            ((d)localObject).field_username = localddb.HrP.getBuffer().ffY();
          }
          if ((localddb.HrO != null) && (localddb.HrO.getBuffer() != null)) {
            ((d)localObject).field_nickname = localddb.HrO.getBuffer().ffY();
          }
          if ((localddb.HrP != null) && (localddb.HrP.getBuffer() != null)) {
            ((d)localObject).field_distance = localddb.HrP.getBuffer().ffY();
          }
          if ((localddb.GCd != null) && (localddb.GCd.getBuffer() != null)) {
            ((d)localObject).field_sns_bgurl = localddb.GCd.getBuffer().ffY();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localddb.toByteArray();
          m.dOO().a((d)localObject, true);
          paramAnonymouscvp.add(localObject);
          j.c(j.this).d(paramAnonymouscvp, paramAnonymousLong);
          AppMethodBeat.o(28308);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
          }
        }
      }
    });
    AppMethodBeat.o(28311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */