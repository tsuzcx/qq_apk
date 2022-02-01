package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.g;

public class ab
  implements b<aa>
{
  protected aa CxS;
  public final d CxT;
  public final b CxU;
  public final c CxV;
  public final a CxW;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68522);
    this.CxT = new d();
    this.CxU = new b();
    this.CxV = new c();
    this.CxW = new a();
    this.CxS = paramaa;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<clv, f<Integer, in, Integer, Integer, String>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<coq, g<String, String, Integer, Integer, String, Integer>>
  {
    public b() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<csl, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<cnl, g<String, String, Integer, Integer, String, Integer>>
  {
    public d() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */