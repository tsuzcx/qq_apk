package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract Collection<? extends b> fQW();
  
  public abstract b fQX();
  
  public abstract a fQY();
  
  public abstract void t(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      Ldo = new a("DECLARATION", 0);
      Ldp = new a("FAKE_OVERRIDE", 1);
      Ldq = new a("DELEGATION", 2);
      Ldr = new a("SYNTHESIZED", 3);
      Lds = new a[] { Ldo, Ldp, Ldq, Ldr };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean fQZ()
    {
      return this != Ldp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */