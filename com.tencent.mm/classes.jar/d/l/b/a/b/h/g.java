package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static volatile boolean NqR;
  private static final g NqT;
  final Map<g.a, i.f<?, ?>> NqS;
  
  static
  {
    AppMethodBeat.i(59446);
    NqR = false;
    NqT = new g((byte)0);
    AppMethodBeat.o(59446);
  }
  
  g()
  {
    AppMethodBeat.i(59444);
    this.NqS = new HashMap();
    AppMethodBeat.o(59444);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(59445);
    this.NqS = Collections.emptyMap();
    AppMethodBeat.o(59445);
  }
  
  public static g grD()
  {
    AppMethodBeat.i(59442);
    g localg = new g();
    AppMethodBeat.o(59442);
    return localg;
  }
  
  public static g grE()
  {
    return NqT;
  }
  
  public final void a(i.f<?, ?> paramf)
  {
    AppMethodBeat.i(59443);
    this.NqS.put(new g.a(paramf.Nrk, paramf.Nrm.number), paramf);
    AppMethodBeat.o(59443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.g
 * JD-Core Version:    0.7.0.1
 */