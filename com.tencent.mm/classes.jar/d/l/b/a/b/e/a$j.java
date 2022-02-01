package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$j
  implements j.a
{
  private static j.b<j> NHN;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    NJg = new j("FINAL", 0, 0);
    NJh = new j("OPEN", 1, 1);
    NJi = new j("ABSTRACT", 2, 2);
    NJj = new j("SEALED", 3, 3);
    NJk = new j[] { NJg, NJh, NJi, NJj };
    NHN = new j.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static j akE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NJg;
    case 1: 
      return NJh;
    case 2: 
      return NJi;
    }
    return NJj;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.j
 * JD-Core Version:    0.7.0.1
 */