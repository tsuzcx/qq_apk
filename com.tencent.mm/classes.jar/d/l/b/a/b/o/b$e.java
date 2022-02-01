package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class b$e<N>
  implements b.d<N>
{
  private final Set<N> Kbg;
  
  public b$e()
  {
    this(new HashSet());
    AppMethodBeat.i(61349);
    AppMethodBeat.o(61349);
  }
  
  private b$e(Set<N> paramSet)
  {
    this.Kbg = paramSet;
  }
  
  public final boolean ft(N paramN)
  {
    AppMethodBeat.i(61350);
    boolean bool = this.Kbg.add(paramN);
    AppMethodBeat.o(61350);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.o.b.e
 * JD-Core Version:    0.7.0.1
 */