package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class x
  implements b<w>
{
  protected w CxG;
  public final d CxH;
  public final a CxI;
  public final b CxJ;
  public final c CxK;
  
  public x()
  {
    this(new w());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private x(w paramw)
  {
    AppMethodBeat.i(68503);
    this.CxH = new d();
    this.CxI = new a();
    this.CxJ = new b();
    this.CxK = new c();
    this.CxG = paramw;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<de, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cbc, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<coe, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<coe> iG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68499);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(68499);
      return localc;
    }
  }
  
  public final class d
    implements e<clm, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */