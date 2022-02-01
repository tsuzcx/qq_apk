package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
  implements ap
{
  a XTm;
  volatile boolean hPS;
  volatile boolean ouJ;
  volatile boolean ryI;
  volatile boolean ryJ;
  
  public aq(a parama)
  {
    this.XTm = parama;
  }
  
  public final void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(151833);
    this.hPS = paramBoolean;
    this.ryJ = true;
    if ((this.ouJ) && (this.XTm != null)) {
      this.XTm.C(paramBoolean, this.ryI);
    }
    AppMethodBeat.o(151833);
  }
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(244828);
    this.ouJ = true;
    this.ryI = paramBoolean1;
    if ((this.ryJ) && (this.XTm != null)) {
      this.XTm.C(this.hPS, paramBoolean1);
    }
    AppMethodBeat.o(244828);
  }
  
  public final void reset()
  {
    this.ouJ = false;
    this.ryI = false;
    this.ryJ = false;
    this.hPS = false;
  }
  
  public static abstract interface a
  {
    public abstract void C(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aq
 * JD-Core Version:    0.7.0.1
 */