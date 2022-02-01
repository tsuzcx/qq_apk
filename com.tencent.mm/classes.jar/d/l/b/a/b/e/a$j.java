package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$j
  implements j.a
{
  private static j.b<j> LtK;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    Lvd = new j("FINAL", 0, 0);
    Lve = new j("OPEN", 1, 1);
    Lvf = new j("ABSTRACT", 2, 2);
    Lvg = new j("SEALED", 3, 3);
    Lvh = new j[] { Lvd, Lve, Lvf, Lvg };
    LtK = new j.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static j aht(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Lvd;
    case 1: 
      return Lve;
    case 2: 
      return Lvf;
    }
    return Lvg;
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