package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$g$b
  implements k.a
{
  private static k.b<b> abag;
  final int value;
  
  static
  {
    AppMethodBeat.i(58575);
    abbj = new b("TRUE", 0, 0);
    abbk = new b("FALSE", 1, 1);
    abbl = new b("NULL", 2, 2);
    abbm = new b[] { abbj, abbk, abbl };
    abag = new k.b() {};
    AppMethodBeat.o(58575);
  }
  
  private a$g$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aEh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abbj;
    case 1: 
      return abbk;
    }
    return abbl;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.g.b
 * JD-Core Version:    0.7.0.1
 */