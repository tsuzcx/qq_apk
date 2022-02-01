package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class ad
  implements b<ac>
{
  protected ac VaB;
  public final b VaC;
  public final a VaD;
  
  public ad()
  {
    this(new ac());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private ad(ac paramac)
  {
    AppMethodBeat.i(68511);
    this.VaC = new b();
    this.VaD = new a();
    this.VaB = paramac;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<dmf, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<eds, Void>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ad
 * JD-Core Version:    0.7.0.1
 */