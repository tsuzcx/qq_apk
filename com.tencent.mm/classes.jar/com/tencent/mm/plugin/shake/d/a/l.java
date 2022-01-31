package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends l.b
{
  private static boolean isInited = false;
  private static boolean isRunning = false;
  private Context context;
  private long iWt;
  private boolean isActive;
  private a qPf;
  
  public l(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(24657);
    this.isActive = false;
    this.qPf = new a();
    this.context = paramContext;
    isRunning = false;
    AppMethodBeat.o(24657);
  }
  
  private void c(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(24661);
    if (this.qNe != null) {
      this.qNe.b(paramList, paramLong);
    }
    AppMethodBeat.o(24661);
  }
  
  public final void ckR()
  {
    AppMethodBeat.i(24660);
    super.ckR();
    this.qPf.Et();
    if (isRunning)
    {
      long l = System.currentTimeMillis() - this.iWt;
      ab.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(isRunning) });
      h.qsU.e(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.qsU.j(835L, 1L, 1L);
      isRunning = false;
    }
    AppMethodBeat.o(24660);
  }
  
  public final void init()
  {
    AppMethodBeat.i(24659);
    if (!isInited)
    {
      if (!this.qPf.clO())
      {
        ab.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(24659);
        return;
      }
      isInited = true;
    }
    AppMethodBeat.o(24659);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(24658);
    ab.v("Micromsg.ShakeTVService", "hy: start shake tv!");
    if (this.qNe == null)
    {
      ab.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(24658);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ab.e("Micromsg.ShakeTVService", "context not an Activity");
      this.qNe.b(new ArrayList(), 0L);
      AppMethodBeat.o(24658);
      return;
    }
    isRunning = true;
    this.iWt = System.currentTimeMillis();
    this.qPf.a(408, new l.1(this));
    h.qsU.j(835L, 5L, 1L);
    AppMethodBeat.o(24658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.l
 * JD-Core Version:    0.7.0.1
 */