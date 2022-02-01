package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
  implements am
{
  a BQD;
  public volatile boolean doI;
  public volatile boolean gWb;
  public volatile boolean jxM;
  public volatile boolean jxN;
  
  public an(a parama)
  {
    this.BQD = parama;
  }
  
  public final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.doI = paramBoolean;
    this.jxN = true;
    if ((this.gWb) && (this.BQD != null)) {
      this.BQD.t(paramBoolean, this.jxM);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190748);
    this.gWb = true;
    this.jxM = paramBoolean1;
    if ((this.jxN) && (this.BQD != null)) {
      this.BQD.t(this.doI, paramBoolean1);
    }
    AppMethodBeat.o(190748);
  }
  
  public static abstract interface a
  {
    public abstract void t(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an
 * JD-Core Version:    0.7.0.1
 */