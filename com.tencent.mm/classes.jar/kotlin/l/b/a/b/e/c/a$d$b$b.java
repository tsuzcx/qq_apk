package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$d$b$b
  implements k.a
{
  private static k.b<b> abag;
  final int value;
  
  static
  {
    AppMethodBeat.i(59200);
    abff = new b("NONE", 0, 0);
    abfg = new b("INTERNAL_TO_CLASS_ID", 1, 1);
    abfh = new b("DESC_TO_CLASS_ID", 2, 2);
    abfi = new b[] { abff, abfg, abfh };
    abag = new k.b() {};
    AppMethodBeat.o(59200);
  }
  
  private a$d$b$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aFp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abff;
    case 1: 
      return abfg;
    }
    return abfh;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */