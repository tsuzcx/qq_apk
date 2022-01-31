package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class p
  implements b<o>
{
  protected o qgf;
  public final c qgg = new c();
  public final p.a qgh = new p.a(this);
  public final b qgi = new b();
  public final p.d qgj = new p.d(this);
  
  public p()
  {
    this(new o());
  }
  
  public p(o paramo)
  {
    this.qgf = paramo;
  }
  
  public final class b
    implements e<y, Integer>
  {
    public b() {}
    
    public final String vP()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<bhk, d<Integer, Integer, Bankcard>>
  {
    public c() {}
    
    public final String vP()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.p
 * JD-Core Version:    0.7.0.1
 */