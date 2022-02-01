package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean icd = false;
  private static boolean isRunning = false;
  private Context context;
  private boolean isActive;
  private long mmC;
  private a xzl;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.xzl = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(28327);
  }
  
  private void e(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.xxk != null) {
      this.xxk.d(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(28330);
    super.dCP();
    this.xzl.NX();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.mmC;
      ac.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.wUl.n(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!icd)
    {
      if (!this.xzl.dDL())
      {
        ac.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      icd = true;
    }
    AppMethodBeat.o(28329);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28328);
    ac.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.xxk == null)
    {
      ac.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ac.e("Micromsg.ShakeTVService", "context not an Activity");
      this.xxk.d(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    isRunning = true;
    this.mmC = System.currentTimeMillis();
    this.xzl.a(408, new a.a()
    {
      public final void b(cqk paramAnonymouscqk, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28326);
        ac.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        cxs localcxs;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i;
        if (paramAnonymousLong > l.a(l.this))
        {
          paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
          if ((paramAnonymouscqk == null) || (bs.isNullOrNil(((cxs)paramAnonymouscqk).EUm))) {
            break label542;
          }
          localcxs = (cxs)paramAnonymouscqk;
          ac.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localcxs.ndI), localcxs.EUm });
          localObject2 = null;
          localObject3 = null;
          paramAnonymouscqk = localObject3;
          localObject1 = localObject2;
          if (localcxs.EUm != null)
          {
            localcxs.EUm = localcxs.EUm.trim();
            i = localcxs.EUm.indexOf("<tvinfo>");
            if (i <= 0) {
              break label358;
            }
            localObject1 = localcxs.EUm.substring(0, i);
            paramAnonymouscqk = localcxs.EUm.substring(i);
          }
          label171:
          l.asm(paramAnonymouscqk);
          switch (localcxs.ndI)
          {
          default: 
            ac.w("Micromsg.ShakeTVService", "parse unknown type:" + localcxs.ndI);
            l.a(l.this, new ArrayList());
            paramAnonymousBoolean = false;
            label266:
            if (paramAnonymousBoolean)
            {
              h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(l.this))) });
              h.wUl.n(835L, 0L, 1L);
            }
            break;
          }
        }
        for (;;)
        {
          l.Ot();
          AppMethodBeat.o(28326);
          return;
          paramAnonymousLong = System.currentTimeMillis() - l.a(l.this);
          break;
          label358:
          if (i == 0)
          {
            paramAnonymouscqk = localcxs.EUm;
            localObject1 = localObject2;
            break label171;
          }
          localObject1 = localcxs.EUm;
          paramAnonymouscqk = localObject3;
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
          h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.wUl.n(835L, 4L, 1L);
          continue;
          label542:
          if (paramAnonymousBoolean)
          {
            l.a(l.this, new ArrayList());
            h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.wUl.n(835L, 3L, 1L);
          }
          else
          {
            l.a(l.this, new ArrayList());
            h.wUl.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
            h.wUl.n(835L, 2L, 1L);
          }
        }
      }
    });
    h.wUl.n(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */