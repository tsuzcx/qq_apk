package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, aa
{
  public abstract void M(Collection<? extends b> paramCollection);
  
  public abstract b a(l paraml, ab paramab, t paramt, a parama);
  
  public abstract Collection<? extends b> kof();
  
  public abstract b kog();
  
  public abstract a koh();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      aiGl = new a("DECLARATION", 0);
      aiGm = new a("FAKE_OVERRIDE", 1);
      aiGn = new a("DELEGATION", 2);
      aiGo = new a("SYNTHESIZED", 3);
      aiGp = new a[] { aiGl, aiGm, aiGn, aiGo };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean koi()
    {
      return this != aiGm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */