package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IListener;

public final class f
{
  public IListener PqU;
  public IListener PqV;
  private IListener PqW;
  public IListener PqX;
  
  public f()
  {
    AppMethodBeat.i(129916);
    this.PqU = new c();
    this.PqV = new f.1(this);
    this.PqW = new f.2(this);
    this.PqX = new f.3(this);
    AppMethodBeat.o(129916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f
 * JD-Core Version:    0.7.0.1
 */