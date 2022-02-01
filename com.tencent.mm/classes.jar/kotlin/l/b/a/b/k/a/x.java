package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;

public final class x
  implements g
{
  private final c aiyk;
  private final a ajlN;
  private final kotlin.g.a.b<kotlin.l.b.a.b.f.b, av> ajmK;
  final Map<kotlin.l.b.a.b.f.b, a.b> ajmL;
  
  public x(a.l paraml, c paramc, a parama, kotlin.g.a.b<? super kotlin.l.b.a.b.f.b, ? extends av> paramb)
  {
    AppMethodBeat.i(60345);
    this.aiyk = paramc;
    this.ajlN = parama;
    this.ajmK = paramb;
    paraml = paraml.ajak;
    s.s(paraml, "proto.class_List");
    paramc = (Iterable)paraml;
    paraml = (Map)new LinkedHashMap(k.qu(ak.aKi(p.a(paramc, 10)), 16));
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      parama = paramc.next();
      paramb = (a.b)parama;
      paraml.put(w.a(this.aiyk, paramb.aiYH), parama);
    }
    this.ajmL = paraml;
    AppMethodBeat.o(60345);
  }
  
  public final f f(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60344);
    s.u(paramb, "classId");
    a.b localb = (a.b)this.ajmL.get(paramb);
    if (localb == null)
    {
      AppMethodBeat.o(60344);
      return null;
    }
    paramb = new f(this.aiyk, localb, this.ajlN, (av)this.ajmK.invoke(paramb));
    AppMethodBeat.o(60344);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.x
 * JD-Core Version:    0.7.0.1
 */