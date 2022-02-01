package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract interface b
  extends a, v
{
  public abstract b a(l paraml, w paramw, ba paramba, a parama);
  
  public abstract a hAA();
  
  public abstract Collection<? extends b> hAy();
  
  public abstract b hAz();
  
  public abstract void x(Collection<? extends b> paramCollection);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56829);
      TgW = new a("DECLARATION", 0);
      TgX = new a("FAKE_OVERRIDE", 1);
      TgY = new a("DELEGATION", 2);
      TgZ = new a("SYNTHESIZED", 3);
      Tha = new a[] { TgW, TgX, TgY, TgZ };
      AppMethodBeat.o(56829);
    }
    
    private a() {}
    
    public final boolean hAB()
    {
      return this != TgX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */