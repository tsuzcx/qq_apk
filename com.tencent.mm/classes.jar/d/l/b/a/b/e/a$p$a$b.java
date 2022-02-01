package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$p$a$b
  implements j.a
{
  private static j.b<b> LtK;
  final int value;
  
  static
  {
    AppMethodBeat.i(58824);
    LvV = new b("IN", 0, 0);
    LvW = new b("OUT", 1, 1);
    LvX = new b("INV", 2, 2);
    LvY = new b("STAR", 3, 3);
    LvZ = new b[] { LvV, LvW, LvX, LvY };
    LtK = new j.b() {};
    AppMethodBeat.o(58824);
  }
  
  private a$p$a$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b ahG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return LvV;
    case 1: 
      return LvW;
    case 2: 
      return LvX;
    }
    return LvY;
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