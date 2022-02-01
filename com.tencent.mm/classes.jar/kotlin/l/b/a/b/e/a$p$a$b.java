package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$p$a$b
  implements j.a
{
  private static j.b<b> Txp;
  final int value;
  
  static
  {
    AppMethodBeat.i(58824);
    TzA = new b("IN", 0, 0);
    TzB = new b("OUT", 1, 1);
    TzC = new b("INV", 2, 2);
    TzD = new b("STAR", 3, 3);
    TzE = new b[] { TzA, TzB, TzC, TzD };
    Txp = new j.b() {};
    AppMethodBeat.o(58824);
  }
  
  private a$p$a$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b auH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TzA;
    case 1: 
      return TzB;
    case 2: 
      return TzC;
    }
    return TzD;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.p.a.b
 * JD-Core Version:    0.7.0.1
 */