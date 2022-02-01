package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.g;

public class ab
  implements b<aa>
{
  public final a zFA;
  protected aa zFw;
  public final d zFx;
  public final b zFy;
  public final c zFz;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68522);
    this.zFx = new d();
    this.zFy = new b();
    this.zFz = new c();
    this.zFA = new a();
    this.zFw = paramaa;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<cbu, f<Integer, ia, Integer, Integer, String>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cen, g<String, String, Integer, Integer, String, Integer>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<cie, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<cdi, g<String, String, Integer, Integer, String, Integer>>
  {
    public d() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */