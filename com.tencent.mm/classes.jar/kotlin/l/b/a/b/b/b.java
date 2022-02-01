package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract Collection<? extends b> iEL();
  
  public abstract b iEM();
  
  public abstract a iEN();
  
  public abstract void v(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      aaJQ = new a("DECLARATION", 0);
      aaJR = new a("FAKE_OVERRIDE", 1);
      aaJS = new a("DELEGATION", 2);
      aaJT = new a("SYNTHESIZED", 3);
      aaJU = new a[] { aaJQ, aaJR, aaJS, aaJT };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean iEO()
    {
      return this != aaJR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */