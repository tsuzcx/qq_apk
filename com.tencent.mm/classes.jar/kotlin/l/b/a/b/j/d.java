package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.e;

public abstract interface d
{
  public abstract b a(a parama1, a parama2, e parame);
  
  public abstract d.a hDu();
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(59939);
      THG = new b("OVERRIDABLE", 0);
      THH = new b("CONFLICT", 1);
      THI = new b("INCOMPATIBLE", 2);
      THJ = new b("UNKNOWN", 3);
      THK = new b[] { THG, THH, THI, THJ };
      AppMethodBeat.o(59939);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.d
 * JD-Core Version:    0.7.0.1
 */