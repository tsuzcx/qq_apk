package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class ac
  implements b<ab>
{
  protected ab OlV;
  public final b OlW;
  public final a OlX;
  
  public ac()
  {
    this(new ab());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private ac(ab paramab)
  {
    AppMethodBeat.i(68511);
    this.OlW = new b();
    this.OlX = new a();
    this.OlV = paramab;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<cuz, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<dlh, Void>
  {
    public b() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac
 * JD-Core Version:    0.7.0.1
 */