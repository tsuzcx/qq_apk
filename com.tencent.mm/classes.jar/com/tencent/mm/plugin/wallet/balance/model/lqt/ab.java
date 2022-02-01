package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.g;

public class ab
  implements b<aa>
{
  public final c CPA;
  public final a CPB;
  protected aa CPx;
  public final d CPy;
  public final b CPz;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68522);
    this.CPy = new d();
    this.CPz = new b();
    this.CPA = new c();
    this.CPB = new a();
    this.CPx = paramaa;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<cmp, f<Integer, in, Integer, Integer, String>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cpk, g<String, String, Integer, Integer, String, Integer>>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<ctf, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<cof, g<String, String, Integer, Integer, String, Integer>>
  {
    public d() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */