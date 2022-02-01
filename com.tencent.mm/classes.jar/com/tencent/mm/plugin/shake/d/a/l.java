package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean hBC = false;
  private static boolean isRunning = false;
  private Context context;
  private boolean isActive;
  private long lKF;
  private a wnU;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.wnU = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(28327);
  }
  
  private void d(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.wlU != null) {
      this.wlU.c(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void doF()
  {
    AppMethodBeat.i(28330);
    super.doF();
    this.wnU.Ob();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.lKF;
      ad.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.vKh.m(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!hBC)
    {
      if (!this.wnU.dpB())
      {
        ad.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      hBC = true;
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
    if (this.wlU == null)
    {
      ad.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ad.e("Micromsg.ShakeTVService", "context not an Activity");
      this.wlU.c(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    isRunning = true;
    this.lKF = System.currentTimeMillis();
    this.wnU.a(408, new a.a()
    {
      public final void b(cld paramAnonymouscld, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28326);
        ad.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        csj localcsj;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i;
        if (paramAnonymousLong > l.a(l.this))
        {
          paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
          if ((paramAnonymouscld == null) || (bt.isNullOrNil(((csj)paramAnonymouscld).DyQ))) {
            break label542;
          }
          localcsj = (csj)paramAnonymouscld;
          ad.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcsj.mBH), localcsj.DyQ });
          localObject2 = null;
          localObject3 = null;
          paramAnonymouscld = localObject3;
          localObject1 = localObject2;
          if (localcsj.DyQ != null)
          {
            localcsj.DyQ = localcsj.DyQ.trim();
            i = localcsj.DyQ.indexOf("<tvinfo>");
            if (i <= 0) {
              break label358;
            }
            localObject1 = localcsj.DyQ.substring(0, i);
            paramAnonymouscld = localcsj.DyQ.substring(i);
          }
          label171:
          l.and(paramAnonymouscld);
          switch (localcsj.mBH)
          {
          default: 
            ad.w("Micromsg.ShakeTVService", "parse unknown type:" + localcsj.mBH);
            l.a(l.this, new ArrayList());
            paramAnonymousBoolean = false;
            label266:
            if (paramAnonymousBoolean)
            {
              h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(l.this))) });
              h.vKh.m(835L, 0L, 1L);
            }
            break;
          }
        }
        for (;;)
        {
          l.Ox();
          AppMethodBeat.o(28326);
          return;
          paramAnonymousLong = System.currentTimeMillis() - l.a(l.this);
          break;
          label358:
          if (i == 0)
          {
            paramAnonymouscld = localcsj.DyQ;
            localObject1 = localObject2;
            break label171;
          }
          localObject1 = localcsj.DyQ;
          paramAnonymouscld = localObject3;
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
          h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.vKh.m(835L, 4L, 1L);
          continue;
          label542:
          if (paramAnonymousBoolean)
          {
            l.a(l.this, new ArrayList());
            h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.vKh.m(835L, 3L, 1L);
          }
          else
          {
            l.a(l.this, new ArrayList());
            h.vKh.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
            h.vKh.m(835L, 2L, 1L);
          }
        }
      }
    });
    h.vKh.m(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */