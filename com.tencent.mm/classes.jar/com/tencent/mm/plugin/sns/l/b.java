package com.tencent.mm.plugin.sns.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a zmi;
  public final b.a zmj;
  public final b.b zmk;
  public final b.c zml;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(100582);
    AppMethodBeat.o(100582);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(100583);
    this.zmj = new b.a(this);
    this.zmk = new b.b(this);
    this.zml = new b.c(this);
    this.zmi = parama;
    AppMethodBeat.o(100583);
  }
  
  public final a dSV()
  {
    return this.zmi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.b
 * JD-Core Version:    0.7.0.1
 */