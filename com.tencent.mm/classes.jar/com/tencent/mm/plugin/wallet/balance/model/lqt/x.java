package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class x
  implements b<w>
{
  protected w OlE;
  public final b OlF;
  public final a OlG;
  public final e OlH;
  public final c OlI;
  public final d OlJ;
  
  public x()
  {
    this(new w());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private x(w paramw)
  {
    AppMethodBeat.i(68490);
    this.OlF = new b();
    this.OlG = new a();
    this.OlH = new e();
    this.OlI = new c();
    this.OlJ = new d();
    this.OlE = paramw;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<abj, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<dri, Void>
  {
    public b() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<dri> bwy()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.ieN().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<ded, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<ded> lf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.H(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<ded, String>
  {
    public d() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class e
    implements e<deh, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public e() {}
    
    public final com.tencent.mm.vending.g.c<deh> ama(int paramInt)
    {
      AppMethodBeat.i(203648);
      com.tencent.mm.vending.g.c localc = g.H(Integer.valueOf(paramInt), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(203648);
      return localc;
    }
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */