package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static final g TDx;
  private static volatile boolean bUg;
  final Map<g.a, i.f<?, ?>> bUk;
  
  static
  {
    AppMethodBeat.i(59446);
    bUg = false;
    TDx = new g((byte)0);
    AppMethodBeat.o(59446);
  }
  
  g()
  {
    AppMethodBeat.i(59444);
    this.bUk = new HashMap();
    AppMethodBeat.o(59444);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(59445);
    this.bUk = Collections.emptyMap();
    AppMethodBeat.o(59445);
  }
  
  public static g hJv()
  {
    AppMethodBeat.i(59442);
    g localg = new g();
    AppMethodBeat.o(59442);
    return localg;
  }
  
  public static g hJw()
  {
    return TDx;
  }
  
  public final void a(i.f<?, ?> paramf)
  {
    AppMethodBeat.i(59443);
    this.bUk.put(new g.a(paramf.TDF, paramf.TDH.number), paramf);
    AppMethodBeat.o(59443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.g
 * JD-Core Version:    0.7.0.1
 */