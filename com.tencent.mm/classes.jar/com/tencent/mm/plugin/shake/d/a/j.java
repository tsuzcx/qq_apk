package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean hBC = false;
  public static j wnV;
  private boolean isActive;
  private long lKF;
  public a wnU;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.wnU = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((wnV == null) || (wnV.wlU == null)) {
      wnV = new j(parama);
    }
    parama = wnV;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void d(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.wlU != null) {
      this.wlU.c(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void doF()
  {
    AppMethodBeat.i(28313);
    this.wnU.Ob();
    super.doF();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!hBC)
    {
      if (!this.wnU.dpB())
      {
        ad.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      hBC = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.wlU == null)
    {
      ad.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.lKF = System.currentTimeMillis();
    this.wnU.a(367, new a.a()
    {
      public final void b(cld paramAnonymouscld, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          ad.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        csf localcsf = (csf)paramAnonymouscld;
        if (localcsf == null)
        {
          ad.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localcsf.Efh == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localcsf == null) || (bt.isNullOrNil(localcsf.Eko))) {
              break label458;
            }
            ad.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcsf.Ekn), localcsf.Eko });
            localObject = localcsf.Eko;
            paramAnonymouscld = (cld)localObject;
            if (localObject != null) {
              paramAnonymouscld = ((String)localObject).trim();
            }
            switch (localcsf.Ekn)
            {
            default: 
              ad.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localcsf.Ekn);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            h.vKh.m(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymouscld);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymouscld);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymouscld);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymouscld);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymouscld);
          }
          label399:
          h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.vKh.m(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.vKh.m(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          h.vKh.m(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymouscld = new ArrayList();
        if (localcsf != null)
        {
          localObject = new d();
          if ((localcsf.Ekj != null) && (localcsf.Ekj.getBuffer() != null)) {
            ((d)localObject).field_username = localcsf.Ekj.getBuffer().eBA();
          }
          if ((localcsf.Eki != null) && (localcsf.Eki.getBuffer() != null)) {
            ((d)localObject).field_nickname = localcsf.Eki.getBuffer().eBA();
          }
          if ((localcsf.Ekj != null) && (localcsf.Ekj.getBuffer() != null)) {
            ((d)localObject).field_distance = localcsf.Ekj.getBuffer().eBA();
          }
          if ((localcsf.Dxo != null) && (localcsf.Dxo.getBuffer() != null)) {
            ((d)localObject).field_sns_bgurl = localcsf.Dxo.getBuffer().eBA();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localcsf.toByteArray();
          m.dpb().a((d)localObject, true);
          paramAnonymouscld.add(localObject);
          j.c(j.this).c(paramAnonymouscld, paramAnonymousLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */