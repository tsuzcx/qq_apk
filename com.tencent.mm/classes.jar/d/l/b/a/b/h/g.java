package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static volatile boolean JMB;
  private static final g JMD;
  final Map<g.a, i.f<?, ?>> JMC;
  
  static
  {
    AppMethodBeat.i(59446);
    JMB = false;
    JMD = new g((byte)0);
    AppMethodBeat.o(59446);
  }
  
  g()
  {
    AppMethodBeat.i(59444);
    this.JMC = new HashMap();
    AppMethodBeat.o(59444);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(59445);
    this.JMC = Collections.emptyMap();
    AppMethodBeat.o(59445);
  }
  
  public static g fHB()
  {
    AppMethodBeat.i(59442);
    g localg = new g();
    AppMethodBeat.o(59442);
    return localg;
  }
  
  public static g fHC()
  {
    return JMD;
  }
  
  public final void a(i.f<?, ?> paramf)
  {
    AppMethodBeat.i(59443);
    this.JMC.put(new g.a(paramf.JMU, paramf.JMW.number), paramf);
    AppMethodBeat.o(59443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.g
 * JD-Core Version:    0.7.0.1
 */