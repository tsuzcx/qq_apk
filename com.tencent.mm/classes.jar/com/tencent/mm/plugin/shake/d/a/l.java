package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean isRunning = false;
  private static boolean lsn = false;
  private a JoD;
  private Context context;
  private boolean isActive;
  private long rgW;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.JoD = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(28327);
  }
  
  private void f(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.JmD != null) {
      this.JmD.e(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void fGS()
  {
    AppMethodBeat.i(28330);
    super.fGS();
    this.JoD.aeJ();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.rgW;
      Log.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.IzE.p(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!lsn)
    {
      if (!this.JoD.fHN())
      {
        Log.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      lsn = true;
    }
    AppMethodBeat.o(28329);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28328);
    Log.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.JmD == null)
    {
      Log.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      Log.e("Micromsg.ShakeTVService", "context not an Activity");
      this.JmD.e(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    isRunning = true;
    this.rgW = System.currentTimeMillis();
    this.JoD.a(g.arZ(), new a.a()
    {
      public final void b(dyy paramAnonymousdyy, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(28326);
        Log.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        ehe localehe;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i;
        if (paramAnonymousLong > l.a(l.this))
        {
          paramAnonymousLong = System.currentTimeMillis() - paramAnonymousLong;
          if ((paramAnonymousdyy == null) || (Util.isNullOrNil(((ehe)paramAnonymousdyy).Tlx))) {
            break label542;
          }
          localehe = (ehe)paramAnonymousdyy;
          Log.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[] { Integer.valueOf(localehe.rWu), localehe.Tlx });
          localObject2 = null;
          localObject3 = null;
          paramAnonymousdyy = localObject3;
          localObject1 = localObject2;
          if (localehe.Tlx != null)
          {
            localehe.Tlx = localehe.Tlx.trim();
            i = localehe.Tlx.indexOf("<tvinfo>");
            if (i <= 0) {
              break label358;
            }
            localObject1 = localehe.Tlx.substring(0, i);
            paramAnonymousdyy = localehe.Tlx.substring(i);
          }
          label171:
          l.aXV(paramAnonymousdyy);
          switch (localehe.rWu)
          {
          default: 
            Log.w("Micromsg.ShakeTVService", "parse unknown type:" + localehe.rWu);
            l.a(l.this, new ArrayList());
            paramAnonymousBoolean = false;
            label266:
            if (paramAnonymousBoolean)
            {
              h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int)(System.currentTimeMillis() - l.a(l.this))) });
              h.IzE.p(835L, 0L, 1L);
            }
            break;
          }
        }
        for (;;)
        {
          l.afi();
          AppMethodBeat.o(28326);
          return;
          paramAnonymousLong = System.currentTimeMillis() - l.a(l.this);
          break;
          label358:
          if (i == 0)
          {
            paramAnonymousdyy = localehe.Tlx;
            localObject1 = localObject2;
            break label171;
          }
          localObject1 = localehe.Tlx;
          paramAnonymousdyy = localObject3;
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
          h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(paramAnonymousLong) });
          h.IzE.p(835L, 4L, 1L);
          continue;
          label542:
          if (paramAnonymousBoolean)
          {
            l.a(l.this, new ArrayList());
            h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int)paramAnonymousLong) });
            h.IzE.p(835L, 3L, 1L);
          }
          else
          {
            l.a(l.this, new ArrayList());
            h.IzE.a(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int)paramAnonymousLong) });
            h.IzE.p(835L, 2L, 1L);
          }
        }
      }
    });
    h.IzE.p(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */