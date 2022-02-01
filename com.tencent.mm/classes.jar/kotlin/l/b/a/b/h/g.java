package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static final g ajfa;
  private static volatile boolean dPS;
  final Map<g.a, i.e<?, ?>> dPW;
  
  static
  {
    AppMethodBeat.i(59446);
    dPS = false;
    ajfa = new g((byte)0);
    AppMethodBeat.o(59446);
  }
  
  g()
  {
    AppMethodBeat.i(59444);
    this.dPW = new HashMap();
    AppMethodBeat.o(59444);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(59445);
    this.dPW = Collections.emptyMap();
    AppMethodBeat.o(59445);
  }
  
  public static g kyf()
  {
    AppMethodBeat.i(59442);
    g localg = new g();
    AppMethodBeat.o(59442);
    return localg;
  }
  
  public static g kyg()
  {
    return ajfa;
  }
  
  public final void a(i.e<?, ?> parame)
  {
    AppMethodBeat.i(59443);
    this.dPW.put(new g.a(parame.ajfk, parame.ajfm.number), parame);
    AppMethodBeat.o(59443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.g
 * JD-Core Version:    0.7.0.1
 */