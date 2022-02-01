package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements al
{
  a JWV;
  volatile boolean dQW;
  volatile boolean iMQ;
  volatile boolean lzY;
  volatile boolean lzZ;
  
  public am(a parama)
  {
    this.JWV = parama;
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.dQW = paramBoolean;
    this.lzZ = true;
    if ((this.iMQ) && (this.JWV != null)) {
      this.JWV.u(paramBoolean, this.lzY);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void reset()
  {
    this.iMQ = false;
    this.lzY = false;
    this.lzZ = false;
    this.dQW = false;
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(223766);
    this.iMQ = true;
    this.lzY = paramBoolean1;
    if ((this.lzZ) && (this.JWV != null)) {
      this.JWV.u(this.dQW, paramBoolean1);
    }
    AppMethodBeat.o(223766);
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