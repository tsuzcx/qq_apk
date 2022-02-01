package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$r$b
  implements k.a
{
  private static k.b<b> abag;
  final int value;
  
  static
  {
    AppMethodBeat.i(58922);
    abcI = new b("IN", 0, 0);
    abcJ = new b("OUT", 1, 1);
    abcK = new b("INV", 2, 2);
    abcL = new b[] { abcI, abcJ, abcK };
    abag = new k.b() {};
    AppMethodBeat.o(58922);
  }
  
  private a$r$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aER(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abcI;
    case 1: 
      return abcJ;
    }
    return abcK;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.r.b
 * JD-Core Version:    0.7.0.1
 */