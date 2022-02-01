package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract Collection<? extends b> giu();
  
  public abstract b giv();
  
  public abstract a giw();
  
  public abstract void u(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      MUj = new a("DECLARATION", 0);
      MUk = new a("FAKE_OVERRIDE", 1);
      MUl = new a("DELEGATION", 2);
      MUm = new a("SYNTHESIZED", 3);
      MUn = new a[] { MUj, MUk, MUl, MUm };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean gix()
    {
      return this != MUk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */