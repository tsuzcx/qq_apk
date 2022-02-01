package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$n$b$b
  implements j.a
{
  private static j.b<b> Txp;
  final int value;
  
  static
  {
    AppMethodBeat.i(58760);
    Tzd = new b("CLASS", 0, 0);
    Tze = new b("PACKAGE", 1, 1);
    Tzf = new b("LOCAL", 2, 2);
    Tzg = new b[] { Tzd, Tze, Tzf };
    Txp = new j.b() {};
    AppMethodBeat.o(58760);
  }
  
  private a$n$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b auF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Tzd;
    case 1: 
      return Tze;
    }
    return Tzf;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.n.b.b
 * JD-Core Version:    0.7.0.1
 */