package d.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$d$b$b
  implements j.a
{
  private static j.b<b> NHN;
  final int value;
  
  static
  {
    AppMethodBeat.i(59200);
    NMN = new b("NONE", 0, 0);
    NMO = new b("INTERNAL_TO_CLASS_ID", 1, 1);
    NMP = new b("DESC_TO_CLASS_ID", 2, 2);
    NMQ = new b[] { NMN, NMO, NMP };
    NHN = new j.b() {};
    AppMethodBeat.o(59200);
  }
  
  private a$d$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b alF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NMN;
    case 1: 
      return NMO;
    }
    return NMP;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */