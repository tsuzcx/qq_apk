package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class ab
  implements b<aa>
{
  protected aa Huj;
  public final b Huk;
  public final a Hul;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68511);
    this.Huk = new b();
    this.Hul = new a();
    this.Huj = paramaa;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<cmd, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<dbs, Void>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */