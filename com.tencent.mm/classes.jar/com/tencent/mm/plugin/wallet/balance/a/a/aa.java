package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class aa
  implements b<z>
{
  protected z tNs;
  public final aa.c tNt;
  public final aa.a tNu;
  public final aa.b tNv;
  public final d tNw;
  
  public aa()
  {
    this(new z());
    AppMethodBeat.i(45326);
    AppMethodBeat.o(45326);
  }
  
  public aa(z paramz)
  {
    AppMethodBeat.i(45327);
    this.tNt = new aa.c(this);
    this.tNu = new aa.a(this);
    this.tNv = new aa.b(this);
    this.tNw = new d();
    this.tNs = paramz;
    AppMethodBeat.o(45327);
  }
  
  public final class d
    implements e<Void, d<Integer, Integer, Integer>>
  {
    public d() {}
    
    public final String HY()
    {
      return "Vending.UI";
    }
    
    public final c<Void> gv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45324);
      c localc = f.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(45324);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.aa
 * JD-Core Version:    0.7.0.1
 */