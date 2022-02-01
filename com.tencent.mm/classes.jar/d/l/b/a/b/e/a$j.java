package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$j
  implements j.a
{
  private static j.b<j> NkH;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    Nma = new j("FINAL", 0, 0);
    Nmb = new j("OPEN", 1, 1);
    Nmc = new j("ABSTRACT", 2, 2);
    Nmd = new j("SEALED", 3, 3);
    Nme = new j[] { Nma, Nmb, Nmc, Nmd };
    NkH = new j.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static j ajU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Nma;
    case 1: 
      return Nmb;
    case 2: 
      return Nmc;
    }
    return Nmd;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.j
 * JD-Core Version:    0.7.0.1
 */