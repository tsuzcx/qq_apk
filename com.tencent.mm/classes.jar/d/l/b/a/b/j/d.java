package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a;
import d.l.b.a.b.b.e;

public abstract interface d
{
  public abstract b a(a parama1, a parama2, e parame);
  
  public abstract a fTR();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(59936);
      LEB = new a("CONFLICTS_ONLY", 0);
      LEC = new a("SUCCESS_ONLY", 1);
      LED = new a("BOTH", 2);
      LEE = new a[] { LEB, LEC, LED };
      AppMethodBeat.o(59936);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(59939);
      LEF = new b("OVERRIDABLE", 0);
      LEG = new b("CONFLICT", 1);
      LEH = new b("INCOMPATIBLE", 2);
      LEI = new b("UNKNOWN", 3);
      LEJ = new b[] { LEF, LEG, LEH, LEI };
      AppMethodBeat.o(59939);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.d
 * JD-Core Version:    0.7.0.1
 */