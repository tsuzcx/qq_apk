package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class b$e<N>
  implements b.d<N>
{
  private final Set<N> abtV;
  
  public b$e()
  {
    this(new HashSet());
    AppMethodBeat.i(61349);
    AppMethodBeat.o(61349);
  }
  
  private b$e(Set<N> paramSet)
  {
    this.abtV = paramSet;
  }
  
  public final boolean fM(N paramN)
  {
    AppMethodBeat.i(61350);
    boolean bool = this.abtV.add(paramN);
    AppMethodBeat.o(61350);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.o.b.e
 * JD-Core Version:    0.7.0.1
 */