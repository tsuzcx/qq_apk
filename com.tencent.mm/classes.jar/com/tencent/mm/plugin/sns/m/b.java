package com.tencent.mm.plugin.sns.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.f;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a xZi;
  public final a xZj;
  public final b xZk;
  public final c xZl;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(100582);
    AppMethodBeat.o(100582);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(100583);
    this.xZj = new a();
    this.xZk = new b();
    this.xZl = new c();
    this.xZi = parama;
    AppMethodBeat.o(100583);
  }
  
  public final a dEw()
  {
    return this.xZi;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, f<String, Integer, Boolean, Integer, Long>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.m.b
 * JD-Core Version:    0.7.0.1
 */