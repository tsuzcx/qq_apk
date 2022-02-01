package com.tencent.mm.plugin.sns.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.f;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a AEd;
  public final a AEe;
  public final b AEf;
  public final c AEg;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(100582);
    AppMethodBeat.o(100582);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(100583);
    this.AEe = new a();
    this.AEf = new b();
    this.AEg = new c();
    this.AEd = parama;
    AppMethodBeat.o(100583);
  }
  
  public final a efh()
  {
    return this.AEd;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
  {
    public b() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, f<String, Integer, Boolean, Integer, Long>>
  {
    public c() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.b
 * JD-Core Version:    0.7.0.1
 */