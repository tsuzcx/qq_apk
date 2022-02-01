package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements al
{
  a ENI;
  volatile boolean dye;
  volatile boolean hOP;
  volatile boolean ksE;
  volatile boolean ksF;
  
  public am(a parama)
  {
    this.ENI = parama;
  }
  
  public final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.dye = paramBoolean;
    this.ksF = true;
    if ((this.hOP) && (this.ENI != null)) {
      this.ENI.u(paramBoolean, this.ksE);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void reset()
  {
    this.hOP = false;
    this.ksE = false;
    this.ksF = false;
    this.dye = false;
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195377);
    this.hOP = true;
    this.ksE = paramBoolean1;
    if ((this.ksF) && (this.ENI != null)) {
      this.ENI.u(this.dye, paramBoolean1);
    }
    AppMethodBeat.o(195377);
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