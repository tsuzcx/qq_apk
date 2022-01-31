package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public class y
  implements b<x>
{
  protected x tMZ;
  public final d tNa;
  public final y.b tNb;
  public final y.c tNc;
  public final y.a tNd;
  
  public y()
  {
    this(new x());
    AppMethodBeat.i(45304);
    AppMethodBeat.o(45304);
  }
  
  private y(x paramx)
  {
    AppMethodBeat.i(45305);
    this.tNa = new d();
    this.tNb = new y.b(this);
    this.tNc = new y.c(this);
    this.tNd = new y.a(this);
    this.tMZ = paramx;
    AppMethodBeat.o(45305);
  }
  
  public final class d
    implements e<bot, f<String, String, Integer, Integer, String>>
  {
    public d() {}
    
    public final String HY()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.y
 * JD-Core Version:    0.7.0.1
 */