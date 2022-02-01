package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$n$b$b
  implements j.a
{
  private static j.b<b> NHN;
  final int value;
  
  static
  {
    AppMethodBeat.i(58760);
    NJB = new b("CLASS", 0, 0);
    NJC = new b("PACKAGE", 1, 1);
    NJD = new b("LOCAL", 2, 2);
    NJE = new b[] { NJB, NJC, NJD };
    NHN = new j.b() {};
    AppMethodBeat.o(58760);
  }
  
  private a$n$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b akP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NJB;
    case 1: 
      return NJC;
    }
    return NJD;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.n.b.b
 * JD-Core Version:    0.7.0.1
 */