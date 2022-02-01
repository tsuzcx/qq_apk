package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$d$b$b
  implements j.a
{
  private static j.b<b> Txp;
  final int value;
  
  static
  {
    AppMethodBeat.i(59200);
    TCr = new b("NONE", 0, 0);
    TCs = new b("INTERNAL_TO_CLASS_ID", 1, 1);
    TCt = new b("DESC_TO_CLASS_ID", 2, 2);
    TCu = new b[] { TCr, TCs, TCt };
    Txp = new j.b() {};
    AppMethodBeat.o(59200);
  }
  
  private a$d$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b avv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TCr;
    case 1: 
      return TCs;
    }
    return TCt;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */