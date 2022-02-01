package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements al
{
  a QXo;
  volatile boolean fKm;
  volatile boolean lCY;
  volatile boolean ovo;
  volatile boolean ovp;
  
  public am(a parama)
  {
    this.QXo = parama;
  }
  
  public final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.fKm = paramBoolean;
    this.ovp = true;
    if ((this.lCY) && (this.QXo != null)) {
      this.QXo.x(paramBoolean, this.ovo);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void reset()
  {
    this.lCY = false;
    this.ovo = false;
    this.ovp = false;
    this.fKm = false;
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187500);
    this.lCY = true;
    this.ovo = paramBoolean1;
    if ((this.ovp) && (this.QXo != null)) {
      this.QXo.x(this.fKm, paramBoolean1);
    }
    AppMethodBeat.o(187500);
  }
  
  public static abstract interface a
  {
    public abstract void x(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.am
 * JD-Core Version:    0.7.0.1
 */