package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$w
  implements j.a
{
  private static j.b<w> NHN;
  private final int value;
  
  static
  {
    AppMethodBeat.i(59045);
    NKQ = new w("INTERNAL", 0, 0);
    NKR = new w("PRIVATE", 1, 1);
    NKS = new w("PROTECTED", 2, 2);
    NKT = new w("PUBLIC", 3, 3);
    NKU = new w("PRIVATE_TO_THIS", 4, 4);
    NKV = new w("LOCAL", 5, 5);
    NKW = new w[] { NKQ, NKR, NKS, NKT, NKU, NKV };
    NHN = new j.b() {};
    AppMethodBeat.o(59045);
  }
  
  private a$w(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static w alt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return NKQ;
    case 1: 
      return NKR;
    case 2: 
      return NKS;
    case 3: 
      return NKT;
    case 4: 
      return NKU;
    }
    return NKV;
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