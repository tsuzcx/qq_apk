package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;

public enum a$b$b
  implements j.a
{
  private static j.b<b> Txp;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58425);
    TxK = new b("CLASS", 0, 0);
    TxL = new b("INTERFACE", 1, 1);
    TxM = new b("ENUM_CLASS", 2, 2);
    TxN = new b("ENUM_ENTRY", 3, 3);
    TxO = new b("ANNOTATION_CLASS", 4, 4);
    TxP = new b("OBJECT", 5, 5);
    TxQ = new b("COMPANION_OBJECT", 6, 6);
    TxR = new b[] { TxK, TxL, TxM, TxN, TxO, TxP, TxQ };
    Txp = new j.b() {};
    AppMethodBeat.o(58425);
  }
  
  private a$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b auf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return TxK;
    case 1: 
      return TxL;
    case 2: 
      return TxM;
    case 3: 
      return TxN;
    case 4: 
      return TxO;
    case 5: 
      return TxP;
    }
    return TxQ;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */