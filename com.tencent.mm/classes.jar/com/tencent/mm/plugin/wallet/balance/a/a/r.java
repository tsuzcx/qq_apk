package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class r
  implements b<q>
{
  protected q tMF;
  public final r.b tMG;
  public final a tMH;
  public final r.d tMI;
  public final r.c tMJ;
  
  public r()
  {
    this(new q());
    AppMethodBeat.i(45275);
    AppMethodBeat.o(45275);
  }
  
  private r(q paramq)
  {
    AppMethodBeat.i(45276);
    this.tMG = new r.b(this);
    this.tMH = new a();
    this.tMI = new r.d(this);
    this.tMJ = new r.c(this);
    this.tMF = paramq;
    AppMethodBeat.o(45276);
  }
  
  public final class a
    implements e<ty, c<String, Integer>>
  {
    public a() {}
    
    public final String HY()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.r
 * JD-Core Version:    0.7.0.1
 */