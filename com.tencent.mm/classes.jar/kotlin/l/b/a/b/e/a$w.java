package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$w
  implements k.a
{
  private static k.b<w> aiYE;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    ajbK = new w("INTERNAL", 0, 0);
    ajbL = new w("PRIVATE", 1, 1);
    ajbM = new w("PROTECTED", 2, 2);
    ajbN = new w("PUBLIC", 3, 3);
    ajbO = new w("PRIVATE_TO_THIS", 4, 4);
    ajbP = new w("LOCAL", 5, 5);
    ajbQ = new w[] { ajbK, ajbL, ajbM, ajbN, ajbO, ajbP };
    aiYE = new k.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static w aLU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ajbK;
    case 1: 
      return ajbL;
    case 2: 
      return ajbM;
    case 3: 
      return ajbN;
    case 4: 
      return ajbO;
    }
    return ajbP;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.w
 * JD-Core Version:    0.7.0.1
 */