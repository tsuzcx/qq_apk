package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
  implements am
{
  a DiS;
  public volatile boolean dmq;
  public volatile boolean hwA;
  public volatile boolean jYi;
  public volatile boolean jYj;
  
  public an(a parama)
  {
    this.DiS = parama;
  }
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.dmq = paramBoolean;
    this.jYj = true;
    if ((this.hwA) && (this.DiS != null)) {
      this.DiS.u(paramBoolean, this.jYi);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192651);
    this.hwA = true;
    this.jYi = paramBoolean1;
    if ((this.jYj) && (this.DiS != null)) {
      this.DiS.u(this.dmq, paramBoolean1);
    }
    AppMethodBeat.o(192651);
  }
  
  public static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an
 * JD-Core Version:    0.7.0.1
 */