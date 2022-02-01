package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract Collection<? extends b> fys();
  
  public abstract b fyt();
  
  public abstract a fyu();
  
  public abstract void s(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      JpV = new a("DECLARATION", 0);
      JpW = new a("FAKE_OVERRIDE", 1);
      JpX = new a("DELEGATION", 2);
      JpY = new a("SYNTHESIZED", 3);
      JpZ = new a[] { JpV, JpW, JpX, JpY };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean fyv()
    {
      return this != JpW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */