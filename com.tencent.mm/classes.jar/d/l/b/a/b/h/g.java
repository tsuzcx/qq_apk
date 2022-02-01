package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static volatile boolean LzU;
  private static final g LzW;
  final Map<a, i.f<?, ?>> LzV;
  
  static
  {
    AppMethodBeat.i(59446);
    LzU = false;
    LzW = new g((byte)0);
    AppMethodBeat.o(59446);
  }
  
  g()
  {
    AppMethodBeat.i(59444);
    this.LzV = new HashMap();
    AppMethodBeat.o(59444);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(59445);
    this.LzV = Collections.emptyMap();
    AppMethodBeat.o(59445);
  }
  
  public static g gae()
  {
    AppMethodBeat.i(59442);
    g localg = new g();
    AppMethodBeat.o(59442);
    return localg;
  }
  
  public static g gaf()
  {
    return LzW;
  }
  
  public final void a(i.f<?, ?> paramf)
  {
    AppMethodBeat.i(59443);
    this.LzV.put(new a(paramf.LAn, paramf.LAp.number), paramf);
    AppMethodBeat.o(59443);
  }
  
  static final class a
  {
    private final int number;
    private final Object object;
    
    a(Object paramObject, int paramInt)
    {
      this.object = paramObject;
      this.number = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.object != paramObject.object) || (this.number != paramObject.number));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(59441);
      int i = System.identityHashCode(this.object);
      int j = this.number;
      AppMethodBeat.o(59441);
      return i * 65535 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.h.g
 * JD-Core Version:    0.7.0.1
 */