package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$w
  implements j.a
{
  private static j.b<w> LtK;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    LwN = new w("INTERNAL", 0, 0);
    LwO = new w("PRIVATE", 1, 1);
    LwP = new w("PROTECTED", 2, 2);
    LwQ = new w("PUBLIC", 3, 3);
    LwR = new w("PRIVATE_TO_THIS", 4, 4);
    LwS = new w("LOCAL", 5, 5);
    LwT = new w[] { LwN, LwO, LwP, LwQ, LwR, LwS };
    LtK = new j.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static w aii(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return LwN;
    case 1: 
      return LwO;
    case 2: 
      return LwP;
    case 3: 
      return LwQ;
    case 4: 
      return LwR;
    }
    return LwS;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.w
 * JD-Core Version:    0.7.0.1
 */