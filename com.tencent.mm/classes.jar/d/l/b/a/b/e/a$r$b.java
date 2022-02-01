package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$r$b
  implements j.a
{
  private static j.b<b> NHN;
  final int value;
  
  static
  {
    AppMethodBeat.i(58922);
    NKp = new b("IN", 0, 0);
    NKq = new b("OUT", 1, 1);
    NKr = new b("INV", 2, 2);
    NKs = new b[] { NKp, NKq, NKr };
    NHN = new j.b() {};
    AppMethodBeat.o(58922);
  }
  
  private a$r$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b alh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NKp;
    case 1: 
      return NKq;
    }
    return NKr;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.r.b
 * JD-Core Version:    0.7.0.1
 */