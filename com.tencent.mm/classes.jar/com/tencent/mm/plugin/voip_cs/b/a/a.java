package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  private static a tKV;
  public h tzl;
  
  private a()
  {
    AppMethodBeat.i(135312);
    this.tzl = new h(ah.getContext());
    AppMethodBeat.o(135312);
  }
  
  public static a cQu()
  {
    AppMethodBeat.i(135313);
    if (tKV == null) {
      tKV = new a();
    }
    a locala = tKV;
    AppMethodBeat.o(135313);
    return locala;
  }
  
  public static a cQv()
  {
    AppMethodBeat.i(135314);
    if (tKV == null) {
      tKV = cQu();
    }
    a locala = tKV;
    AppMethodBeat.o(135314);
    return locala;
  }
  
  public final boolean cOm()
  {
    AppMethodBeat.i(135317);
    if (this.tzl != null)
    {
      boolean bool = this.tzl.Dt();
      AppMethodBeat.o(135317);
      return bool;
    }
    AppMethodBeat.o(135317);
    return true;
  }
  
  public final void cQw()
  {
    AppMethodBeat.i(135315);
    if (this.tzl != null) {
      this.tzl.aq(0, true);
    }
    AppMethodBeat.o(135315);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(135316);
    if (this.tzl != null) {
      this.tzl.stop();
    }
    AppMethodBeat.o(135316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.a
 * JD-Core Version:    0.7.0.1
 */