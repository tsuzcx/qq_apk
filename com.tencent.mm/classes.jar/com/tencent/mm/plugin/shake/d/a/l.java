package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean isRunning = false;
  private static boolean ivz = false;
  private Context context;
  private boolean isActive;
  private long mNe;
  private a yNV;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.yNV = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(28327);
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.yLV != null) {
      this.yLV.d(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void dOs()
  {
    AppMethodBeat.i(28330);
    super.dOs();
    this.yNV.PG();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.mNe;
      ad.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      g.yhR.n(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!ivz)
    {
      if (!this.yNV.dPo())
      {
        ad.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      ivz = true;
    }
    AppMethodBeat.o(28329);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28328);
    ad.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.yLV == null)
    {
      ad.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ad.e("Micromsg.ShakeTVService", "context not an Activity");
      this.yLV.d(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    isRunning = true;
    this.mNe = System.currentTimeMillis();
    this.yNV.a(408, new a.a()
    {
      public final void b(cvp paramAnonymouscvp, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28326);
        ad.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        ddf localddf;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i;
        if (paramAnonymousLong > l.a(l.this))
        {
          paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
          if ((paramAnonymouscvp == null) || (bt.isNullOrNil(((ddf)paramAnonymouscvp).GDJ))) {
            break label542;
          }
          localddf = (ddf)paramAnonymouscvp;
          ad.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localddf.nEf), localddf.GDJ });
          localObject2 = null;
          localObject3 = null;
          paramAnonymouscvp = localObject3;
          localObject1 = localObject2;
          if (localddf.GDJ != null)
          {
            localddf.GDJ = localddf.GDJ.trim();
            i = localddf.GDJ.indexOf("<tvinfo>");
            if (i <= 0) {
              break label358;
            }
            localObject1 = localddf.GDJ.substring(0, i);
            paramAnonymouscvp = localddf.GDJ.substring(i);
          }
          label171:
          l.axm(paramAnonymouscvp);
          switch (localddf.nEf)
          {
          default: 
            ad.w("Micromsg.ShakeTVService", "parse unknown type:" + localddf.nEf);
            l.a(l.this, new ArrayList());
            paramAnonymousBoolean = false;
            label266:
            if (paramAnonymousBoolean)
            {
              g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(l.this))) });
              g.yhR.n(835L, 0L, 1L);
            }
            break;
          }
        }
        for (;;)
        {
          l.Qc();
          AppMethodBeat.o(28326);
          return;
          paramAnonymousLong = System.currentTimeMillis() - l.a(l.this);
          break;
          label358:
          if (i == 0)
          {
            paramAnonymouscvp = localddf.GDJ;
            localObject1 = localObject2;
            break label171;
          }
          localObject1 = localddf.GDJ;
          paramAnonymouscvp = localObject3;
          break label171;
          paramAnonymousBoolean = l.a(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.b(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.c(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.d(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.e(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.f(l.this, (String)localObject1);
          break label266;
          paramAnonymousBoolean = l.g(l.this, (String)localObject1);
          break label266;
          g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          g.yhR.n(835L, 4L, 1L);
          continue;
          label542:
          if (paramAnonymousBoolean)
          {
            l.a(l.this, new ArrayList());
            g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            g.yhR.n(835L, 3L, 1L);
          }
          else
          {
            l.a(l.this, new ArrayList());
            g.yhR.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
            g.yhR.n(835L, 2L, 1L);
          }
        }
      }
    });
    g.yhR.n(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */