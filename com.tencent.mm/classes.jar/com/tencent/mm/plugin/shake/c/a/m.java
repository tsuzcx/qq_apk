package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.model.l.a;
import com.tencent.mm.plugin.shake.model.l.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends l.b
{
  public static m PBC;
  public k.b PAT;
  private a PBB;
  private boolean isActive;
  private long uoS;
  
  private m(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28310);
    this.isActive = false;
    this.PBB = new a();
    AppMethodBeat.o(28310);
  }
  
  public static m a(l.a parama)
  {
    AppMethodBeat.i(28309);
    if ((PBC == null) || (PBC.Pzt == null)) {
      PBC = new m(parama);
    }
    parama = PBC;
    AppMethodBeat.o(28309);
    return parama;
  }
  
  public final void gWH()
  {
    AppMethodBeat.i(28313);
    this.PBB.aGH();
    super.gWH();
    AppMethodBeat.o(28313);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28312);
    AppMethodBeat.o(28312);
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    AppMethodBeat.i(28311);
    if (this.Pzt == null)
    {
      Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      AppMethodBeat.o(28311);
      return;
    }
    this.uoS = System.currentTimeMillis();
    this.PBB.PAT = this.PAT;
    this.PBB.a(new m..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(28311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.m
 * JD-Core Version:    0.7.0.1
 */