package com.tencent.mm.plugin.sns.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.f;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a AVG;
  public final a AVH;
  public final b AVI;
  public final c AVJ;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(100582);
    AppMethodBeat.o(100582);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(100583);
    this.AVH = new a();
    this.AVI = new b();
    this.AVJ = new c();
    this.AVG = parama;
    AppMethodBeat.o(100583);
  }
  
  public final a eiO()
  {
    return this.AVG;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, f<String, Integer, Boolean, Integer, Long>>
  {
    public c() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.b
 * JD-Core Version:    0.7.0.1
 */