package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$j
  implements j.a
{
  private static j.b<j> Txp;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    TyI = new j("FINAL", 0, 0);
    TyJ = new j("OPEN", 1, 1);
    TyK = new j("ABSTRACT", 2, 2);
    TyL = new j("SEALED", 3, 3);
    TyM = new j[] { TyI, TyJ, TyK, TyL };
    Txp = new j.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static j auu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TyI;
    case 1: 
      return TyJ;
    case 2: 
      return TyK;
    }
    return TyL;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.j
 * JD-Core Version:    0.7.0.1
 */