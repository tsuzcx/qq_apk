package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$w
  implements j.a
{
  private static j.b<w> Txp;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    TAs = new w("INTERNAL", 0, 0);
    TAt = new w("PRIVATE", 1, 1);
    TAu = new w("PROTECTED", 2, 2);
    TAv = new w("PUBLIC", 3, 3);
    TAw = new w("PRIVATE_TO_THIS", 4, 4);
    TAx = new w("LOCAL", 5, 5);
    TAy = new w[] { TAs, TAt, TAu, TAv, TAw, TAx };
    Txp = new j.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static w avj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TAs;
    case 1: 
      return TAt;
    case 2: 
      return TAu;
    case 3: 
      return TAv;
    case 4: 
      return TAw;
    }
    return TAx;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.w
 * JD-Core Version:    0.7.0.1
 */