package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements al
{
  a Fge;
  volatile boolean dzj;
  volatile boolean hRI;
  volatile boolean kvU;
  volatile boolean kvV;
  
  public am(a parama)
  {
    this.Fge = parama;
  }
  
  public final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.dzj = paramBoolean;
    this.kvV = true;
    if ((this.hRI) && (this.Fge != null)) {
      this.Fge.u(paramBoolean, this.kvU);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void reset()
  {
    this.hRI = false;
    this.kvU = false;
    this.kvV = false;
    this.dzj = false;
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(218830);
    this.hRI = true;
    this.kvU = paramBoolean1;
    if ((this.kvV) && (this.Fge != null)) {
      this.Fge.u(this.dzj, paramBoolean1);
    }
    AppMethodBeat.o(218830);
  }
  
  public static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.am
 * JD-Core Version:    0.7.0.1
 */