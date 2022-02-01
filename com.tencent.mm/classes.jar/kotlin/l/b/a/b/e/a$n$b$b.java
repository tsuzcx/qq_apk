package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$n$b$b
  implements k.a
{
  private static k.b<b> abag;
  final int value;
  
  static
  {
    AppMethodBeat.i(58760);
    abbU = new b("CLASS", 0, 0);
    abbV = new b("PACKAGE", 1, 1);
    abbW = new b("LOCAL", 2, 2);
    abbX = new b[] { abbU, abbV, abbW };
    abag = new k.b() {};
    AppMethodBeat.o(58760);
  }
  
  private a$n$b$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aEz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abbU;
    case 1: 
      return abbV;
    }
    return abbW;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.n.b.b
 * JD-Core Version:    0.7.0.1
 */