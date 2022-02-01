package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$r$b
  implements j.a
{
  private static j.b<b> Txp;
  final int value;
  
  static
  {
    AppMethodBeat.i(58922);
    TzR = new b("IN", 0, 0);
    TzS = new b("OUT", 1, 1);
    TzT = new b("INV", 2, 2);
    TzU = new b[] { TzR, TzS, TzT };
    Txp = new j.b() {};
    AppMethodBeat.o(58922);
  }
  
  private a$r$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b auX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TzR;
    case 1: 
      return TzS;
    }
    return TzT;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.r.b
 * JD-Core Version:    0.7.0.1
 */