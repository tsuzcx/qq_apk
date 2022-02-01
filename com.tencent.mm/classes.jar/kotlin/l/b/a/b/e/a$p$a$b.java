package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$p$a$b
  implements k.a
{
  private static k.b<b> abag;
  final int value;
  
  static
  {
    AppMethodBeat.i(58824);
    abcr = new b("IN", 0, 0);
    abcs = new b("OUT", 1, 1);
    abct = new b("INV", 2, 2);
    abcu = new b("STAR", 3, 3);
    abcv = new b[] { abcr, abcs, abct, abcu };
    abag = new k.b() {};
    AppMethodBeat.o(58824);
  }
  
  private a$p$a$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aEB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abcr;
    case 1: 
      return abcs;
    case 2: 
      return abct;
    }
    return abcu;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.p.a.b
 * JD-Core Version:    0.7.0.1
 */