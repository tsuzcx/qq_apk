package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$i
  implements j.a
{
  private static j.b<i> Txp;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58622);
    TyD = new i("DECLARATION", 0, 0);
    TyE = new i("FAKE_OVERRIDE", 1, 1);
    TyF = new i("DELEGATION", 2, 2);
    TyG = new i("SYNTHESIZED", 3, 3);
    TyH = new i[] { TyD, TyE, TyF, TyG };
    Txp = new j.b() {};
    AppMethodBeat.o(58622);
  }
  
  private a$i(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static i aut(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TyD;
    case 1: 
      return TyE;
    case 2: 
      return TyF;
    }
    return TyG;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */