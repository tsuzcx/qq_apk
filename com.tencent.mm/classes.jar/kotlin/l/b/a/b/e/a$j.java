package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$j
  implements k.a
{
  private static k.b<j> abag;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    abbz = new j("FINAL", 0, 0);
    abbA = new j("OPEN", 1, 1);
    abbB = new j("ABSTRACT", 2, 2);
    abbC = new j("SEALED", 3, 3);
    abbD = new j[] { abbz, abbA, abbB, abbC };
    abag = new k.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static j aEo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return abbz;
    case 1: 
      return abbA;
    case 2: 
      return abbB;
    }
    return abbC;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.j
 * JD-Core Version:    0.7.0.1
 */