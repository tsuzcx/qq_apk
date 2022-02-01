package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a;
import d.l.b.a.b.b.e;

public abstract interface d
{
  public abstract b a(a parama1, a parama2, e parame);
  
  public abstract a gpS();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(59936);
      NSG = new a("CONFLICTS_ONLY", 0);
      NSH = new a("SUCCESS_ONLY", 1);
      NSI = new a("BOTH", 2);
      NSJ = new a[] { NSG, NSH, NSI };
      AppMethodBeat.o(59936);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(59939);
      NSK = new b("OVERRIDABLE", 0);
      NSL = new b("CONFLICT", 1);
      NSM = new b("INCOMPATIBLE", 2);
      NSN = new b("UNKNOWN", 3);
      NSO = new b[] { NSK, NSL, NSM, NSN };
      AppMethodBeat.o(59939);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.d
 * JD-Core Version:    0.7.0.1
 */