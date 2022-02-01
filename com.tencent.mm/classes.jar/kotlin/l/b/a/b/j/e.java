package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a;

public abstract interface e
{
  public abstract b a(a parama1, a parama2, kotlin.l.b.a.b.b.e parame);
  
  public abstract e.a krB();
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(59939);
      ajiQ = new b("OVERRIDABLE", 0);
      ajiR = new b("CONFLICT", 1);
      ajiS = new b("INCOMPATIBLE", 2);
      ajiT = new b("UNKNOWN", 3);
      ajiU = new b[] { ajiQ, ajiR, ajiS, ajiT };
      AppMethodBeat.o(59939);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e
 * JD-Core Version:    0.7.0.1
 */