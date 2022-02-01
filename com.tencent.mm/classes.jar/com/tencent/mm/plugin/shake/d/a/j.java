package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends l.b
{
  public static j JoE;
  public static boolean lsn = false;
  public a JoD;
  private boolean isActive;
  private long rgW;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.JoD = new a();
    AppMethodBeat.o(28310);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((JoE == null) || (JoE.JmD == null)) {
      JoE = new j(parama);
    }
    parama = JoE;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  private void f(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28314);
    if (this.JmD != null) {
      this.JmD.e(paramList, paramLong);
    }
    AppMethodBeat.o(28314);
  }
  
  public final void fGS()
  {
    AppMethodBeat.i(28313);
    this.JoD.aeJ();
    super.fGS();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    if (!lsn)
    {
      if (!this.JoD.fHN())
      {
        Log.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28312);
        return;
      }
      lsn = true;
    }
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.JmD == null)
    {
      Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.rgW = System.currentTimeMillis();
    this.JoD.a(f.arZ(), new a.a()
    {
      public final void b(dyy paramAnonymousdyy, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28308);
        if (j.a(j.this) == null)
        {
          Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
          AppMethodBeat.o(28308);
          return;
        }
        eha localeha = (eha)paramAnonymousdyy;
        if (localeha == null)
        {
          Log.w("Micromsg.ShakeMusicMgr", "resp null & return");
          j.a(j.this, new ArrayList());
          AppMethodBeat.o(28308);
          return;
        }
        Object localObject;
        if (localeha.Udm == 1)
        {
          if (paramAnonymousLong > j.b(j.this))
          {
            paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
            if ((localeha == null) || (Util.isNullOrNil(localeha.UjA))) {
              break label458;
            }
            Log.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localeha.Ujz), localeha.UjA });
            localObject = localeha.UjA;
            paramAnonymousdyy = (dyy)localObject;
            if (localObject != null) {
              paramAnonymousdyy = ((String)localObject).trim();
            }
            switch (localeha.Ujz)
            {
            default: 
              Log.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + localeha.Ujz);
              j.a(j.this, new ArrayList());
              paramAnonymousBoolean = false;
            }
          }
          for (;;)
          {
            if (!paramAnonymousBoolean) {
              break label399;
            }
            h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - j.b(j.this))) });
            h.IzE.p(835L, 0L, 1L);
            AppMethodBeat.o(28308);
            return;
            paramAnonymousLong = System.currentTimeMillis() - j.b(j.this);
            break;
            paramAnonymousBoolean = j.a(j.this, paramAnonymousdyy);
            continue;
            paramAnonymousBoolean = j.b(j.this, paramAnonymousdyy);
            continue;
            paramAnonymousBoolean = j.c(j.this, paramAnonymousdyy);
            continue;
            paramAnonymousBoolean = j.d(j.this, paramAnonymousdyy);
            continue;
            paramAnonymousBoolean = j.e(j.this, paramAnonymousdyy);
          }
          label399:
          h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.IzE.p(835L, 4L, 1L);
          AppMethodBeat.o(28308);
          return;
          label458:
          if (paramAnonymousBoolean)
          {
            j.a(j.this, new ArrayList());
            h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.IzE.p(835L, 3L, 1L);
            AppMethodBeat.o(28308);
            return;
          }
          j.a(j.this, new ArrayList());
          h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
          h.IzE.p(835L, 2L, 1L);
          AppMethodBeat.o(28308);
          return;
        }
        paramAnonymousdyy = new ArrayList();
        if (localeha != null)
        {
          localObject = new d();
          if ((localeha.Ujv != null) && (localeha.Ujv.Tkb != null)) {
            ((d)localObject).field_username = localeha.Ujv.Tkb.Ap();
          }
          if ((localeha.Uju != null) && (localeha.Uju.Tkb != null)) {
            ((d)localObject).field_nickname = localeha.Uju.Tkb.Ap();
          }
          if ((localeha.Ujv != null) && (localeha.Ujv.Tkb != null)) {
            ((d)localObject).field_distance = localeha.Ujv.Tkb.Ap();
          }
          if ((localeha.Tjq != null) && (localeha.Tjq.Tkb != null)) {
            ((d)localObject).field_sns_bgurl = localeha.Tjq.Tkb.Ap();
          }
          ((d)localObject).field_type = 4;
          ((d)localObject).field_insertBatch = 1;
        }
        try
        {
          ((d)localObject).field_lvbuffer = localeha.toByteArray();
          m.fHo().a((d)localObject, true);
          paramAnonymousdyy.add(localObject);
          j.c(j.this).e(paramAnonymousdyy, paramAnonymousLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */