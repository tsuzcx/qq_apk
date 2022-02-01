package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$b$b
  implements j.a
{
  private static j.b<b> NHN;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58425);
    NIi = new b("CLASS", 0, 0);
    NIj = new b("INTERFACE", 1, 1);
    NIk = new b("ENUM_CLASS", 2, 2);
    NIl = new b("ENUM_ENTRY", 3, 3);
    NIm = new b("ANNOTATION_CLASS", 4, 4);
    NIn = new b("OBJECT", 5, 5);
    NIo = new b("COMPANION_OBJECT", 6, 6);
    NIp = new b[] { NIi, NIj, NIk, NIl, NIm, NIn, NIo };
    NHN = new j.b() {};
    AppMethodBeat.o(58425);
  }
  
  private a$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b akp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NIi;
    case 1: 
      return NIj;
    case 2: 
      return NIk;
    case 3: 
      return NIl;
    case 4: 
      return NIm;
    case 5: 
      return NIn;
    }
    return NIo;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */