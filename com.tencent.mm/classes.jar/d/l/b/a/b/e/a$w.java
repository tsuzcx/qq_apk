package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$w
  implements j.a
{
  private static j.b<w> NkH;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    NnK = new w("INTERNAL", 0, 0);
    NnL = new w("PRIVATE", 1, 1);
    NnM = new w("PROTECTED", 2, 2);
    NnN = new w("PUBLIC", 3, 3);
    NnO = new w("PRIVATE_TO_THIS", 4, 4);
    NnP = new w("LOCAL", 5, 5);
    NnQ = new w[] { NnK, NnL, NnM, NnN, NnO, NnP };
    NkH = new j.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static w akJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NnK;
    case 1: 
      return NnL;
    case 2: 
      return NnM;
    case 3: 
      return NnN;
    case 4: 
      return NnO;
    }
    return NnP;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.w
 * JD-Core Version:    0.7.0.1
 */