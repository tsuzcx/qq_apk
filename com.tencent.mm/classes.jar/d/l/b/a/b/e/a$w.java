package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$w
  implements j.a
{
  private static j.b<w> JGr;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    JJu = new w("INTERNAL", 0, 0);
    JJv = new w("PRIVATE", 1, 1);
    JJw = new w("PROTECTED", 2, 2);
    JJx = new w("PUBLIC", 3, 3);
    JJy = new w("PRIVATE_TO_THIS", 4, 4);
    JJz = new w("LOCAL", 5, 5);
    JJA = new w[] { JJu, JJv, JJw, JJx, JJy, JJz };
    JGr = new j.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static w afm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return JJu;
    case 1: 
      return JJv;
    case 2: 
      return JJw;
    case 3: 
      return JJx;
    case 4: 
      return JJy;
    }
    return JJz;
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