package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract Collection<? extends b> gmW();
  
  public abstract b gmX();
  
  public abstract a gmY();
  
  public abstract void u(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      Nro = new a("DECLARATION", 0);
      Nrp = new a("FAKE_OVERRIDE", 1);
      Nrq = new a("DELEGATION", 2);
      Nrr = new a("SYNTHESIZED", 3);
      Nrs = new a[] { Nro, Nrp, Nrq, Nrr };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean gmZ()
    {
      return this != Nrp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */