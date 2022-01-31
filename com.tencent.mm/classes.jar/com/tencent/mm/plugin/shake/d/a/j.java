package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean isInited = false;
  public static j qPg;
  private long iWt;
  private boolean isActive;
  public a qPf;
  
  private j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(24640);
    this.isActive = false;
    this.qPf = new a();
    AppMethodBeat.o(24640);
  }
  
  public static j a(l.a parama)
  {
    AppMethodBeat.i(24639);
    if ((qPg == null) || (qPg.qNe == null)) {
      qPg = new j(parama);
    }
    parama = qPg;
    AppMethodBeat.o(24639);
    return parama;
  }
  
  private void c(List<d> paramList, long paramLong)
  {
    AppMethodBeat.i(24644);
    if (this.qNe != null) {
      this.qNe.b(paramList, paramLong);
    }
    AppMethodBeat.o(24644);
  }
  
  public final void ckR()
  {
    AppMethodBeat.i(24643);
    this.qPf.Et();
    super.ckR();
    AppMethodBeat.o(24643);
  }
  
  public final void init()
  {
    AppMethodBeat.i(24642);
    if (!isInited)
    {
      if (!this.qPf.clO())
      {
        ab.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
        AppMethodBeat.o(24642);
        return;
      }
      isInited = true;
    }
    AppMethodBeat.o(24642);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(24641);
    if (this.qNe == null)
    {
      ab.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(24641);
      return;
    }
    this.iWt = System.currentTimeMillis();
    this.qPf.a(367, new j.1(this));
    AppMethodBeat.o(24641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */