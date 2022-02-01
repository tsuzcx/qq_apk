package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.g;

public class ab
  implements b<aa>
{
  protected aa AXJ;
  public final d AXK;
  public final b AXL;
  public final c AXM;
  public final a AXN;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68522);
    this.AXK = new d();
    this.AXL = new b();
    this.AXM = new c();
    this.AXN = new a();
    this.AXJ = paramaa;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<cgw, f<Integer, ig, Integer, Integer, String>>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cjq, g<String, String, Integer, Integer, String, Integer>>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<cni, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<cil, g<String, String, Integer, Integer, String, Integer>>
  {
    public d() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */