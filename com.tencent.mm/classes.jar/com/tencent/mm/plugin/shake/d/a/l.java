package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean isRunning = false;
  private static boolean iys = false;
  private Context context;
  private boolean isActive;
  private long mSh;
  private a zef;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.zef = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(28327);
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.zcf != null) {
      this.zcf.d(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void dRP()
  {
    AppMethodBeat.i(28330);
    super.dRP();
    this.zef.PF();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.mSh;
      ae.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      g.yxI.n(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!iys)
    {
      if (!this.zef.dSL())
      {
        ae.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      iys = true;
    }
    AppMethodBeat.o(28329);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28328);
    ae.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.zcf == null)
    {
      ae.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ae.e("Micromsg.ShakeTVService", "context not an Activity");
      this.zcf.d(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    isRunning = true;
    this.mSh = System.currentTimeMillis();
    this.zef.a(408, new a.a()
    {
      public final void b(cwj paramAnonymouscwj, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28326);
        ae.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        ddz localddz;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i;
        if (paramAnonymousLong > l.a(l.this))
        {
          paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
          if ((paramAnonymouscwj == null) || (bu.isNullOrNil(((ddz)paramAnonymouscwj).GXm))) {
            break label542;
          }
          localddz = (ddz)paramAnonymouscwj;
          ae.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localddz.nJA), localddz.GXm });
          localObject2 = null;
          localObject3 = null;
          paramAnonymouscwj = localObject3;
          localObject1 = localObject2;
          if (localddz.GXm != null)
          {
            localddz.GXm = localddz.GXm.trim();
            i = localddz.GXm.indexOf("<tvinfo>");
            if (i <= 0) {
              break label358;
            }
            localObject1 = localddz.GXm.substring(0, i);
            paramAnonymouscwj = localddz.GXm.substring(i);
          }
          label171:
          l.ayC(paramAnonymouscwj);
          switch (localddz.nJA)
          {
          default: 
            ae.w("Micromsg.ShakeTVService", "parse unknown type:" + localddz.nJA);
            l.a(l.this, new ArrayList());
            paramAnonymousBoolean = false;
            label266:
            if (paramAnonymousBoolean)
            {
              g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(l.this))) });
              g.yxI.n(835L, 0L, 1L);
            }
            break;
          }
        }
        for (;;)
        {
          l.Qb();
          AppMethodBeat.o(28326);
          return;
          paramAnonymousLong = System.currentTimeMillis() - l.a(l.this);
          break;
          label358:
          if (i == 0)
          {
            paramAnonymouscwj = localddz.GXm;
            localObject1 = localObject2;
            break label171;
          }
          localObject1 = localddz.GXm;
          paramAnonymouscwj = localObject3;
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
          g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          g.yxI.n(835L, 4L, 1L);
          continue;
          label542:
          if (paramAnonymousBoolean)
          {
            l.a(l.this, new ArrayList());
            g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            g.yxI.n(835L, 3L, 1L);
          }
          else
          {
            l.a(l.this, new ArrayList());
            g.yxI.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
            g.yxI.n(835L, 2L, 1L);
          }
        }
      }
    });
    g.yxI.n(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */