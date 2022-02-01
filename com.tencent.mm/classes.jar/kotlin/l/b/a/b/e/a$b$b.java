package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$b$b
  implements k.a
{
  private static k.b<b> abag;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58425);
    abaB = new b("CLASS", 0, 0);
    abaC = new b("INTERFACE", 1, 1);
    abaD = new b("ENUM_CLASS", 2, 2);
    abaE = new b("ENUM_ENTRY", 3, 3);
    abaF = new b("ANNOTATION_CLASS", 4, 4);
    abaG = new b("OBJECT", 5, 5);
    abaH = new b("COMPANION_OBJECT", 6, 6);
    abaI = new b[] { abaB, abaC, abaD, abaE, abaF, abaG, abaH };
    abag = new k.b() {};
    AppMethodBeat.o(58425);
  }
  
  private a$b$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b aDZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abaB;
    case 1: 
      return abaC;
    case 2: 
      return abaD;
    case 3: 
      return abaE;
    case 4: 
      return abaF;
    case 5: 
      return abaG;
    }
    return abaH;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */