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
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static j DiY;
  public static boolean iCs = false;
  public a DiX;
  private boolean isActive;
  private long ofl;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.DiX = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((DiY == null) || (DiY.DgX == null)) {
      DiY = new j(parama);
    }
    parama = DiY;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void g(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.DgX != null) {
      this.DgX.f(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void eTQ()
  {
    AppMethodBeat.i(28313);
    this.DiX.ZZ();
    super.eTQ();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!iCs)
    {
      if (!this.DiX.eUM())
      {
        Log.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      iCs = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.DgX == null)
    {
      Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.ofl = System.currentTimeMillis();
    this.DiX.a(367, new a.a()
    {
      public final void b(dpc paramAnonymousdpc, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        dwz localdwz = (dwz)paramAnonymousdpc;
        if (localdwz == null)
        {
          Log.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localdwz.MRg == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localdwz == null) || (Util.isNullOrNil(localdwz.MXf))) {
              break label458;
            }
            Log.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localdwz.MXe), localdwz.MXf });
            localObject = localdwz.MXf;
            paramAnonymousdpc = (dpc)localObject;
            if (localObject != null) {
              paramAnonymousdpc = ((String)localObject).trim();
            }
            switch (localdwz.MXe)
            {
            default: 
              Log.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localdwz.MXe);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            h.CyF.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            h.CyF.n(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymousdpc);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymousdpc);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymousdpc);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymousdpc);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymousdpc);
          }
          label399:
          h.CyF.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.CyF.n(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            h.CyF.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.CyF.n(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          h.CyF.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          h.CyF.n(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymousdpc = new ArrayList();
        if (localdwz != null)
        {
          localObject = new d();
          if ((localdwz.MXa != null) && (localdwz.MXa.getBuffer() != null)) {
            ((d)localObject).field_username = localdwz.MXa.getBuffer().yO();
          }
          if ((localdwz.MWZ != null) && (localdwz.MWZ.getBuffer() != null)) {
            ((d)localObject).field_nickname = localdwz.MWZ.getBuffer().yO();
          }
          if ((localdwz.MXa != null) && (localdwz.MXa.getBuffer() != null)) {
            ((d)localObject).field_distance = localdwz.MXa.getBuffer().yO();
          }
          if ((localdwz.LZX != null) && (localdwz.LZX.getBuffer() != null)) {
            ((d)localObject).field_sns_bgurl = localdwz.LZX.getBuffer().yO();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localdwz.toByteArray();
          m.eUm().a((d)localObject, true);
          paramAnonymousdpc.add(localObject);
          j.c(j.this).f(paramAnonymousdpc, paramAnonymousLong);
          AppMethodBeat.o(28308);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[] { localIOException.getLocalizedMessage() });
          }
        }
      }
    });
    AppMethodBeat.o(28311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */