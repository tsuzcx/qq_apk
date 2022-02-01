package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$p$a$b
  implements j.a
{
  private static j.b<b> NHN;
  final int value;
  
  static
  {
    AppMethodBeat.i(58824);
    NJY = new b("IN", 0, 0);
    NJZ = new b("OUT", 1, 1);
    NKa = new b("INV", 2, 2);
    NKb = new b("STAR", 3, 3);
    NKc = new b[] { NJY, NJZ, NKa, NKb };
    NHN = new j.b() {};
    AppMethodBeat.o(58824);
  }
  
  private a$p$a$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b akR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NJY;
    case 1: 
      return NJZ;
    case 2: 
      return NKa;
    }
    return NKb;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.p.a.b
 * JD-Core Version:    0.7.0.1
 */