package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;

public enum a$j
  implements k.a
{
  private static k.b<j> aiYE;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58626);
    ajaa = new j("FINAL", 0, 0);
    ajab = new j("OPEN", 1, 1);
    ajac = new j("ABSTRACT", 2, 2);
    ajad = new j("SEALED", 3, 3);
    ajae = new j[] { ajaa, ajab, ajac, ajad };
    aiYE = new k.b() {};
    AppMethodBeat.o(58626);
  }
  
  private a$j(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static j aLf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ajaa;
    case 1: 
      return ajab;
    case 2: 
      return ajac;
    }
    return ajad;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.j
 * JD-Core Version:    0.7.0.1
 */