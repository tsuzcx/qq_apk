package com.tencent.mm.plugin.shake.c.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.model.d;
import com.tencent.mm.plugin.shake.model.l.a;
import com.tencent.mm.plugin.shake.model.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends l.b
{
  private static boolean Uz = false;
  private static boolean ojM = false;
  private b PBE;
  private Context context;
  private boolean isActive;
  private long uoS;
  
  public o(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28327);
    this.isActive = false;
    this.PBE = new b();
    this.context = paramContext;
    Uz = false;
    AppMethodBeat.o(28327);
  }
  
  private void h(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(28331);
    if (this.Pzt != null) {
      this.Pzt.g(paramList, paramLong);
    }
    AppMethodBeat.o(28331);
  }
  
  public final void gWH()
  {
    AppMethodBeat.i(28330);
    super.gWH();
    this.PBE.aGH();
    if (Uz)
    {
      long l = System.currentTimeMillis() - this.uoS;
      Log.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(Uz) });
      h.OAn.b(10987, new Object[] { Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int)l) });
      h.OAn.p(835L, 1L, 1L);
      Uz = false;
    }
    AppMethodBeat.o(28330);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28329);
    if (!ojM)
    {
      if (!this.PBE.gXD())
      {
        Log.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(28329);
        return;
      }
      ojM = true;
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
    if (this.Pzt == null)
    {
      Log.w("Micromsg.ShakeTVService", "shakeGetListener == null");
      AppMethodBeat.o(28328);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      Log.e("Micromsg.ShakeTVService", "context not an Activity");
      this.Pzt.g(new ArrayList(), 0L);
      AppMethodBeat.o(28328);
      return;
    }
    Uz = true;
    this.uoS = System.currentTimeMillis();
    this.PBE.a(i.aLV(), new o..ExternalSyntheticLambda0(this));
    h.OAn.p(835L, 5L, 1L);
    AppMethodBeat.o(28328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.o
 * JD-Core Version:    0.7.0.1
 */