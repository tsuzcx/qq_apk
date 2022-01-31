package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean isInited = false;
  private static boolean isRunning = false;
  private boolean bFk = false;
  private Context context;
  private long hkx;
  private a oaW = new a();
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    this.context = paramContext;
    isRunning = false;
  }
  
  private void b(List<d> paramList, long paramLong)
  {
    if (this.nYU != null) {
      this.nYU.a(paramList, paramLong);
    }
  }
  
  public final void bzH()
  {
    super.bzH();
    this.oaW.uh();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.hkx;
      y.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      h.nFQ.f(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.nFQ.h(835L, 1L, 1L);
      isRunning = false;
    }
  }
  
  public final void init()
  {
    if (!isInited)
    {
      if (!this.oaW.bAu()) {
        y.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
      }
    }
    else {
      return;
    }
    isInited = true;
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    y.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.nYU == null)
    {
      y.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      return;
    }
    if (!(this.context instanceof Activity))
    {
      y.e("Micromsg.ShakeTVService", "context not an Activity");
      this.nYU.a(new ArrayList(), 0L);
      return;
    }
    isRunning = true;
    this.hkx = System.currentTimeMillis();
    this.oaW.a(408, new l.1(this));
    h.nFQ.h(835L, 5L, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */